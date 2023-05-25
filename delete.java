package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		     try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
				 Connection con=DriverManager.getConnection(dburl);
				 PreparedStatement pst=con.prepareStatement("delete from emp where emp_no=?");
				 pst.setInt(1, Integer.valueOf(request.getParameter("dno")));
				 pst.executeUpdate();
				 out.print("<br><a href=\"home.jsp\"><button type=\"button\">home page </button></a>");		
					
				 con.close();
				 pst.close();
			 }
		     catch (Exception e) {
					System.out.println(e);
					}
	}

}
