package org.calculator.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalcServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter writer = response.getWriter()) {
            response.setContentType("text/html");

            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String operation = request.getParameter("operation");

            switch (operation) {
                case "Addition":
                    writer.println((Double.parseDouble(num1) + Double.parseDouble(num2)));
                    break;
                case "Subtraction":
                    writer.println(Double.parseDouble(num1) - Double.parseDouble(num2));
                    break;
                case "Multiplication":
                    writer.println(Double.parseDouble(num1) * Double.parseDouble(num2));
                    break;
                default:
                    writer.println(Double.parseDouble(num1) / Double.parseDouble(num2));
                    break;
            }
        }
    }
}