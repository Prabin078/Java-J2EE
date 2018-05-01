<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.HashMap" %>
    <%
	    HashMap<String,String> users = new HashMap<String,String>();
		users.put("john","harvard");
		users.put("jharvard", "crimson");
    	String status = request.getParameter("status");
    	String username="";
    	int opStat = 0;
    	if(status!=null)	{
    		if(status.equals("2"))
    			session.invalidate();
    		else{
	    		username = request.getParameter("username");
	    		String password = request.getParameter("password");
	    		if(!users.containsKey(username))	{
	    			opStat = 1;
	    		}
	    		else if(users.containsKey(username))	{
	    			if(!users.get(username).equals(password))	{
	    				opStat = 2;
	    			}
	    			else if(users.get(username).equals(password))	{
	    				session.setAttribute("user", username);
	    				response.sendRedirect("StoreTaxData.jsp");
	    			}
	    		}
    		}
    	}
    %>
    
<!DOCTYPE html>
<html lang="en">

<head>
	
	<title>Income Tax Calculator</title>

	

</head>

<body>

	           <form  method="get">
					<input type="hidden" value="1" name="status"/>
                    <!-- Form Name -->
                    <b>Login</b>
                    <%if(opStat == 1){ %>
					<div>Invalid Username</div>
					<%}else if(opStat == 2){ %>
					<div>Wrong password</div>
					<%}%>
					<hr>
                    <!-- Text input-->
                    <div >
                      <label for="username">Username</label>  
                      
                      <input id="username" name="username" type="text" placeholder="username" required="" <%if(opStat == 2) out.print("value="+username); %>>
                      
                    </div>

                    <!-- Password input-->
                    <div >
                      <label for="password">Password</label>                      
                      <input id="password" name="password" type="password" placeholder="password" class="form-control input-md" required="">
                    </div>
                        <!-- Button -->
                    <div>
                      <labelfor="login"></label>
				      <button id="login" name="login" class="btn btn-primary">Login</button>
                     
                    </div>
   
                </form>
       

	

</body>

</html>