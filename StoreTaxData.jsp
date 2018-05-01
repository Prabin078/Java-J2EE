<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%
    	String user = (String)session.getAttribute("user");
    	if(user == null)
    		response.sendRedirect("index.jsp");
    	Date date = new Date();
    %>
<!DOCTYPE html>
<html lang="en">

<head>
	
	<title>Income Tax Calculator</title>

</head>

<body>

		<h2> Welcome <%=user %></h2>
		<h3>Date: <%=date.toString() %></h3>
	
	    <form class="form-horizontal" action="CalculateTax.jsp">
           
            <b>Fill In Details</b>

            <!-- Text input-->
            <div >
              <label for="name">Name</label>  
              <input id="name" name="name" type="text" placeholder="Will Smith" required="">
            </div>

          
            <div >
              <label  for="gender">Gender</label>
             
              <label for="gender-0">
                <input type="radio" name="gender" id="gender-0" value="male" checked="checked">
                Male
              </label> 
              <label for="gender-1">
                <input type="radio" name="gender" id="gender-1" value="female">
                Female
              </label>
             
            </div>

            <!-- Select Basic -->
            <div>
              <label for="org">Organization</label>
              <div>
                <select id="org" name="org" ">
                  <option value="google">Google</option>
                  <option value="apple">Apple</option>
                  <option value="ms">Microsoft</option>
                  <option value="tcs">TCS</option>
                  <option value="wipro">Wipro</option>
                  <option value="cog">Cognizant</option>
                  <option value="dell">Dell</option>
                  <option value="hp">HP</option>
                  <option value="infy">Infosys</option>
                </select>
              </div>
            </div>
             <!-- Number input-->
                    <div >
                      <label for="salary">Salary</label>  
                      <div>
                      <input id="salary" name="salary" type="number" placeholder="Salary" required="">                      
                      </div>
                    </div>
			   <!-- Button -->
                    <div>
                      <label for="submit"></label>
                     <button id="submit" name="submit">Calculate Tax</button>
 
                    </div>
          
        </form>



<%
	if(session.getAttribute("name") != null)	{
		String name = (String)session.getAttribute("name");
		String gender = (String)session.getAttribute("gender");
		String org = (String)session.getAttribute("org");
		double salary = (Double)session.getAttribute("salary");
		double incomeTax = (Double)session.getAttribute("it");
		double percent = (Double)session.getAttribute("percent");
		
	
%>
	
	<div>
		<h2> Income Tax</h2>
		<p>
			Name: <%=name %><br/>
			Gender: <%=gender %><br/>
			Organization: <%=org %><br/>
			Salary: <%=salary %><br/>
			Income Tax: <%=incomeTax %><br/>
			Percentage: <%=percent %>%<br/>
		</p>
	</div>
	<%} %>
	<a  href="index.jsp?status=2">Logout</a>
	</div>

	

	<script>
	</script>

</body>

</html>
