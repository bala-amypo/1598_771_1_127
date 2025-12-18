package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/ping", "/health"})
public class SimpleEchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        if (req.getRequestURI().contains("/ping")) {
            resp.getWriter().write("PONG");
        } else {
            resp.getWriter().write("OK");
        }
    }
}
