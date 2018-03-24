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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatStore
extends HttpServlet {
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter printWriter = httpServletResponse.getWriter();
        try {
            httpServletResponse.setContentType("text/html");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
            Statement statement = connection.createStatement();
            String string = httpServletRequest.getParameter("uname");
            String string2 = httpServletRequest.getParameter("msg");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm:ss a");
            Date date = new Date();
            String string3 = simpleDateFormat.format(date);
            String string4 = simpleDateFormat2.format(date);
            String string5 = "insert into chatting_data values('" + string + "','" + string2 + "','" + string3 + "','" + string4 + "',seq_chatting_data.nextval)";
            ResultSet resultSet = statement.executeQuery(string5);
            resultSet.next();
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