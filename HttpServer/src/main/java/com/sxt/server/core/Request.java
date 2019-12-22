package com.sxt.server.core;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;


public class Request {

    private String requestInfo;
    private String method;
    private String url;
    private String queryStr;
    private Map<String, List<String>> parameterMap;
    private Socket client;
    private final  String CRLF = "\r\n";


    public Request(Socket client) {
        parameterMap = new HashMap<String,List<String>>();
        byte[] datas = new byte[1024*1024];
        int len = 0;
        try {
            len = client.getInputStream().read(datas);
            this.requestInfo = new String(datas,0, len);
            parseRequestInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRequestInfo() {
        this.method = this.requestInfo.substring(0, this.requestInfo.indexOf(" ")).toLowerCase().trim();
        this.url = this.requestInfo.substring(this.requestInfo.indexOf("/") + 1, requestInfo.indexOf("HTTP/")).trim();
        if (this.url.contains("?")) {
            String[] urlArray = this.url.split("\\?");
            this.url = "/" + urlArray[0];
            this.queryStr =urlArray[1];
        }

        if (method.equals("post")) {
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (StringUtils.isBlank(qStr)) {
                this.queryStr =qStr;
            }else {
                this.queryStr +="&"+qStr;
            }
        }

        convertMap();

    }

    private void convertMap() {
        System.out.println(queryStr);
        String[] keyValues = this.queryStr.split("&");

        for (String query: keyValues) {
            String[] kv = query.split("=");
            kv = Arrays.copyOf(kv, 2);
            String key = kv[0];
            String value = kv[1] == null ? null : decode(kv[1], "utf-8");

            if (!parameterMap.containsKey(key)) {
                parameterMap.put(key, new ArrayList<String>());
            }
            parameterMap.get(key).add(value);
        }
    }

    private String decode(String value,String enc) {
        try {
            return java.net.URLDecoder.decode(value, enc);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String[] getParameterValues(String key) {
        List<String> values = this.parameterMap.get(key);
        if (values == null || values.isEmpty()) {
            return null;
        }
        return (String[]) values.toArray();
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }



}
