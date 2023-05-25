package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
			 Connection con=DriverManager.getConnection(dburl);
			 PreparedStatement pst=con.prepareStatement("INSERT INTO `empproject`.`emp` (`emp_no`, `emp_name`, `emp_age`, `emp_pno`,`emp_role`,`emp_city`,`emp_eid`) VALUES (?,?,?,?,?,?,?);");
			 pst.setInt(1, Integer.valueOf(request.getParameter("empno")));
			 pst.setString(2, request.getParameter("name"));
			 pst.setInt(3, Integer.valueOf(request.getParameter("age")));
			 pst.setString(4, request.getParameter("pno"));
			 pst.setString(5, request.getParameter("role"));
			 pst.setString(6, request.getParameter("city"));
			 pst.setString(7, request.getParameter("eid"));
			 pst.executeUpdate();
			 out.print("<br><a href=\"home.jsp\"><button type=\"button\">home page </button></a>");		
				
			 con.close();
			 pst.close();
		 }
			 
 catch (Exception e) {
			 System.out.println(e);
			 }

		
	

}}
