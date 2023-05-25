package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String u=request.getParameter("user");
		 String p=request.getParameter("pass");
		 PrintWriter out=response.getWriter();
		 if(u!=null && p!=null) {
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
				Connection con=DriverManager.getConnection(dburl);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from admin  where userid='"+u+"' and userid='"+p+"'");
		 /*String u1=rs.getString(1);
		 String p1=rs.getString(2);*/
		 if(rs.next()) {
		
			 response.sendRedirect("home.jsp");
		 }
		 else {
	response.sendRedirect("login.jsp");
			 out.print("invalid");
		 }
		 }
	 
	

	 catch (Exception e) {
	out.println(e);
	}}}}
	
	
