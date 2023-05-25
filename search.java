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
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1= Integer.valueOf(request.getParameter("sno"));
		 PrintWriter out = response.getWriter();
		   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
				Connection con=DriverManager.getConnection(dburl);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from emp where emp_no='"+n1+"' ");
				rs.next();
				/*out.print("Emp_no:"+ rs.getInt(1)+"\n"+"Emp_Name:"+rs.getString(2)+"\n"+"Emp_Age:"+rs.getInt(3)+"\n"+"Emp_Pno:"+rs.getString(4)+"\n"+"Emp_Role:"+rs.getString(5)+"\n"+"Emp_City:"+rs.getString(6)+"\n"+"Emp_Eid:"+rs.getString(7));				
				*/
				 out.println("<table border='"+1+"' >");
				 out.println("<thead>");
				 out.println("<tr>");
				 out.println("<th>" + "Emp_No"+ "</th>");
				 out.println("<th>" + "Emp_Name"+ "</th>");
				 out.println("<th>" + "Emp_Age"+ "</th>");
				 out.println("<th>" + "Emp_Pho"+ "</th>");
				 out.println("<th>" + "Emp_Role"+ "</th>");
				 out.println("<th>" + "Emp_City"+ "</th>");
				 out.println("<th>" + "Emp_Email"+ "</th>");
				 out.println("</tr>");
				 out.println("</thead>");
				 out.println("<tbody>");
				 out.println("<tr>");
				 out.println("<td>" + rs.getInt(1)+ "</td>");
				 out.println("<td>" + rs.getString(2)+ "</td>");
				 out.println("<td>" + rs.getInt(3)+ "</td>");
				 out.println("<td>" + rs.getString(4)+ "</td>");
				 out.println("<td>" + rs.getString(5)+ "</td>");
				 out.println("<td>" + rs.getString(6)+ "</td>");
				 out.println("<td>" + rs.getString(7)+ "</td>");
				 out.println("</tr>");
				 out.println("</thead>");
				 out.println("</table>");
				 out.print("<br><a href=\"home.jsp\"><button type=\"button\">Home page</button></a>");		
					
				con.close();
				st.close();
			} catch (Exception e) {
				System.out.println(e);
				} 	
	}

}
