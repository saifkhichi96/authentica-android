package com.bytexcite.verisign.util;

import co.aspirasoft.apis.rest.HttpServer;

import java.net.MalformedURLException;


public class WebServer extends HttpServer {
    private static final String SERVER_ADDRESS = "http://verisign.saifkhichi.com/src/controller/";
    // private static final String SERVER_ADDRESS = "http://192.168.43.223/projects/apps/VerSign/versign-web/src/controller/";

    public WebServer() throws MalformedURLException {
        super(SERVER_ADDRESS);
    }
}