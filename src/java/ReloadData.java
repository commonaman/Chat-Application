/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
//package com.chatting;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReloadData
extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            httpServletResponse.setContentType("text/html");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
            String string = "select * from chatting_data";
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string2 = resultSet.getString(1);
                String string3 = resultSet.getString(2);
                String string4 = resultSet.getString(3);
                String string5 = resultSet.getString(4);
                PrintWriter printWriter = httpServletResponse.getWriter();
                printWriter.print("<p>" + string2 + "-<g>" + string3 + "</g><br><small>" + string4 + " " + string5 + "</small></p>");
            }
            connection.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Something went wrong");
        }
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.doGet(httpServletRequest, httpServletResponse);
    }
}