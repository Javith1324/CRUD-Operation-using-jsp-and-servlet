package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminregister
 */
@WebServlet("/adminregister")
public class adminregister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out=response.getWriter();
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
			 Connection con=DriverManager.getConnection(dburl);
			 PreparedStatement pst=con.prepareStatement("INSERT INTO `empproject`.`admin` (`userid`, `password`) VALUES (?,?);");
			
			 pst.setString(1, request.getParameter("us1"));
			 pst.setString(2, request.getParameter("ps1"));
			 pst.executeUpdate();
			 con.close();
			 pst.close();
			 out.print("<br><a href=\"login.jsp\"><button type=\"button\">Login page</button></a>");
		 }
			 
 catch (Exception e) {
			 System.out.println(e);
			 }
	}

}
