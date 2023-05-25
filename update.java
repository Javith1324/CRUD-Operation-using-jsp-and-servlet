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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n2=Integer.valueOf(request.getParameter("n1"));
		String p2=request.getParameter("p1");
		String r2=request.getParameter("r1");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			Statement st=con.createStatement();
			st.executeUpdate("update emp set emp_pno='"+p2+"' ,emp_role='"+r2+"' where emp_no='"+n2+"';");			
			out.print("<br><a href=\"home.jsp\"><button type=\"button\">home page </button></a>");		
			
			} catch (Exception e) {
			System.out.println(e);
			}

	}

}
