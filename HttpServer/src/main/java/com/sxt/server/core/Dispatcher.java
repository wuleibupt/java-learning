package com.sxt.server.core;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable{

    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher(Socket client) {
        this.client = client;
        this.request = new Request(client);
        this.response = new Response(client);
    }

    @Override
    public void run() {
        try {
            Servlet servlet = WebApp.getServletFromUtl(request.getUrl());
            System.out.println(servlet);
            if (servlet != null) {
                servlet.service(request, response);
                response.pushToBrowser(200);
            } else {
                response.pushToBrowser(404);
            }
        } catch (Exception e) {
            response.println("服务器错误");
            response.pushToBrowser(500);
        }
        release();
    }

    private void release() {
        try {
            client.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
