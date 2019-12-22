package com.sxt.server.core;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class Response {

    private Socket client;
    private StringBuilder headInfo;
    private final String BLANK =" ";
    private final  String CRLF = "\r\n";
    private StringBuilder content;
    private int len;

    public Response(Socket client) {
        this.client = client;
        this.content = new StringBuilder();
        this.headInfo = new StringBuilder();

    }

    public void pushToBrowser(int code)  {
        try {
            if (headInfo == null) {
                code = 505;
            }
            createHeadInfo(code);
            IOUtils.write(this.headInfo, this.client.getOutputStream(),"utf-8");
            IOUtils.write(this.content, this.client.getOutputStream(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Response println(String info) {
        this.content.append(info).append(CRLF);
        this.len += (info + CRLF).getBytes().length;
        return this;
    }


    private void createHeadInfo(int code) {
        this.headInfo.append("HTTP/1.1").append(BLANK);
        this.headInfo.append(code).append(BLANK);
        switch(code) {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        this.headInfo.append("Date:").append(new Date()).append(CRLF);
        this.headInfo.append("Server:").append("shsxt Server/0.0.1;charset=utf-8").append(CRLF);
        this.headInfo.append("Content-type:text/html").append(CRLF);
        this.headInfo.append("Content-length:").append(len).append(CRLF);
        this.headInfo.append(CRLF);

    }
}
