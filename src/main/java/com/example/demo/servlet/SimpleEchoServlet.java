package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SimpleEchoServlet extends HttpServlet {

    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            response.getWriter().write("Hello, Guest");
        } else {
            response.getWriter().write("Hello, " + name.trim());
        }

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
