package org.javatop.orginal.controller;

import org.javatop.orginal.service.DemoService;
import org.javatop.orginal.service.DemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-06-17 16:23
 * @description : 测试第一个Servlet
 */
@WebServlet(urlPatterns = "/demo1")
public class DemoServlet01 extends HttpServlet {
    
    private DemoService demoService = new DemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println(demoService.findAll().toString());
    }
}
