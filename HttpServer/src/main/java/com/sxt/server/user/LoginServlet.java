package com.sxt.server.user;

import com.sxt.server.core.Request;
import com.sxt.server.core.Response;
import com.sxt.server.core.Servlet;

public class LoginServlet implements Servlet {


    @Override
    public void service(Request request, Response response) {
        response.println("LoginServlet");
    }
}
