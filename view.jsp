<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view data</title>
</head>
<body bgcolor="gray">
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/empproject?user=root&password=root";
	Connection con=DriverManager.getConnection(dburl);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from emp");
	%>
	<table border=1 align="center">
	<thead>
	<tr>
	<th>Emp_No</th>
	<th>Emp_Name</th>
	<th>Age</th>
	<th>Emp_pno</th>
	<th>Emp_role</th>
	<th>Emp_city</th>
	<th>Emp_email</th>
	</head>
	<tbody>
	<%
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getInt(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td><%=rs.getString(7) %></td> <br> 
		</tr>
		<%} %>
		</tbody></table><br>
	
	<% }
	

 catch (Exception e) {
out.println(e);%>
<%}
	%>
	
<br><a href="home.jsp"><button type="button">home page </button></a>
</body>
</html>