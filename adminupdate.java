package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminupdate
 */
@WebServlet("/adminupdate")
public class adminupdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String p2=request.getParameter("user");
		String r2=request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			Statement st=con.createStatement();
			st.executeUpdate("update admin set password='"+p2+"'  where userid='"+r2+"';");			
			out.print("<br><a href=\"login.jsp\"><button type=\"button\">Login page</button></a>");		
			} catch (Exception e) {
			System.out.println(e);
			}

	}

}
