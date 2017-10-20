package ua.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "I am using " + request.getMethod() + " method to read this form data";
        String docType = "<!DOCTYPE html>\n";
        /*out.println(docType +
        "<html>\n"+
        "<head><title>" + title + "</title></head>\n" +
        "<body bgcolor = \"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n" +
        "<ul>\n" +
        "<li><b>User's first name</b>: " +
        request.getParameter("first_name") + "\n" +
        "<li><b>User's last name</b>: " +
        request.getParameter("last_name") + "<\n>" +
        "</ul>\n" +
        "</body></html>");
        */
        out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body>" +"<h1>" + title + "</h1>"
                +
                "<ul>\n" +
                "<li><b>User's first name</b>: " +
                request.getParameter("first_name") + "\n" +
                "<li><b>User's last name</b>: " +
                request.getParameter("last_name") + "\n" +
                "</ul>\n" + "</body></html>");
    }
}
