<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%
    String URL = "jdbc:mysql://localhost:3306/java";
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String USER = "jharvard";
    String PASS = "crimson";
    Connection conn=null;
    try {
    	Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(URL,USER,PASS);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    %>
    <%
    	String day = request.getParameter("day");
    	Statement s = conn.createStatement();
    	String sql = "select * from flight where day='"+day+"'";
    	ResultSet rs = s.executeQuery(sql);
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Flights</title>
</head>
<body>
<h2>All flights on <%=day %></h2>
	<table border="1">
		<tr>
			<th>Flight Number</th>
			<th>Name</th>
			<th>Day</th>
		</tr>
		<% while(rs.next()){%>
			<tr>
				<td><%=rs.getString("flightnumber") %></td>
				<td><%=rs.getString("name") %></td>
				<td><%=rs.getString("day") %></td>
			</tr>
		<%}%>
	</table>
</body>
</html>