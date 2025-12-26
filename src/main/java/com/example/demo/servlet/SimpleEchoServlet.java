package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/ping", "/health"})
public class SimpleEchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");

        String uri = request.getRequestURI();

        if (uri.endsWith("/ping")) {
            response.getWriter().write("PONG");
        } else if (uri.endsWith("/health")) {
            response.getWriter().write("OK");
        }
    }
}
