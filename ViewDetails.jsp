<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%@page import="java.util.*" %>
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
    	int flno = Integer.parseInt(request.getParameter("flno"));
    	String date = request.getParameter("date");
    	String name = request.getParameter("name");
    	String number = request.getParameter("number");
    	Random r = new Random();
    	String seat = ""+r.nextInt(500);
    	//System.out.println(flno + " " + date+ " " +name+ " " +number+ " " +seat);
    %>
    <%
    	boolean flag = false;
    	Statement s = conn.createStatement();
    	String sql = "select flightnumber from flight";
    	ResultSet rs = s.executeQuery(sql);
    	while(rs.next()){
    		if(rs.getInt("flightnumber") == flno)
    			flag = true;
    	}
    %>
    <%
    	if(flag)	{
    		String sql1 = "INSERT INTO  seatReservation (flightNumber ,date ,seat ,passenger,number) VALUES (?,?,?,?,?)";
    		PreparedStatement p = conn.prepareStatement(sql1);
    		p.setInt(1, flno);
    		p.setString(2, date);
    		p.setString(3, seat);
    		p.setString(4, name);
    		p.setString(5, number);
    		p.executeUpdate();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservation</title>
</head>
<body>
	<h1>Online Reservation</h1>
	<hr/>
	<%if(!flag){ %>
		<h2>Invalid Flight Number</h2>
	<%}else{ %>
		<p>Flight Number: <%=flno %><br/>
		Name: <%=name %><br/>
		Number: <%=number %><br/>
		Seat: <%=seat %><br/>
		Date: <%=date %><br/>
		</p>
	<%} %>
</body>
</html>