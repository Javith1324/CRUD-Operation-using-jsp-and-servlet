<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
#d1{
background-color: rgb(202, 199, 194); 
 width: max-content;
            border:1px;
            border-color: black;
            border-radius:7px;
            border-style: solid;
            padding:10px;
            margin-top: 100px;
            margin-left: 500px;
            background-color:rgba(0, 0, 0, 0.178);
            font-size:medium;
}
.b1{
font-weight: bold;
    color: black;
    border-color:rgb(172, 172, 111);
font-style: italic;
padding:5px;
border-radius:5px;
background-color: rgb(202, 199, 194);  
  font-size:big;
  border:1px solid black;
  
  
}
</style>
</head>
<body>
<h1>Welcome to Home page</h1>
		<br>
		<div id="d1">
		<table>
		<tbody>
		<tr>
		<a href="register.jsp"><button type="button" class="b1">Register</button></a>
		</tr>
		<tr>
		<a href="search.jsp"><button type="button"class="b1">Search</button></a>
		</tr>
		<tr>
		<a href="update.jsp"><button type="button"class="b1">Update</button></a>
		</tr>
		<tr>
		<a href="delete.jsp"><button type="button"class="b1">Delete</button></a>
		</tr>
		<tr>
		<a href="view.jsp"><button type="button" class="b1">View Details</button></a>
		</tr>
		<tr>
		<a href="login.jsp"><button type="button"class="b1">Log out</button></a></tr>
		
		</tbody>
		</table>
		</div>
</body>
</html>