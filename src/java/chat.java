/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
//package com.chatting;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class chat extends HttpServlet {
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter printWriter = httpServletResponse.getWriter();
        try {
            httpServletResponse.setContentType("text/html");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
            Statement statement = connection.createStatement();
            String string = httpServletRequest.getParameter("uname");
            System.out.println(string);
            String string2 = httpServletRequest.getParameter("pw");
            System.out.println(string2);
            String string3 = "select*from chatting where username='" + string + "' AND password='" + string2 + "'";
            ResultSet resultSet = statement.executeQuery(string3);
            if (resultSet.next()) {
                String string4 = resultSet.getString("username");
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setAttribute("name", (Object)string4);
                printWriter.println("Welcome, " + string4.toUpperCase());
                printWriter.println("<a href='startchat.jsp'>let's Enter the Chat Room</a>");
                printWriter.println("<a href='logout.jsp' class='logout-chat'>Logout</a>");
            } else {
                printWriter.println("Incorrect Username or Password.");
            }
            connection.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Invalid User");
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.doGet(httpServletRequest, httpServletResponse);
    }
}