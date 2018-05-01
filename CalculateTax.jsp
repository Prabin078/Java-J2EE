<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String user = (String)session.getAttribute("user");
if(user == null)
	response.sendRedirect("index.jsp");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String org = request.getParameter("org");
double salary = Double.parseDouble(request.getParameter("salary"));
double incomeTax = 0.0;
double percent = 0.0;
if(salary>10000 && salary <= 500000)
	percent = 15.0;
else if(salary>500000)
	percent = 20.0;
incomeTax = salary * percent / 100;
session.setAttribute("name", name);
session.setAttribute("gender", gender);
session.setAttribute("org",org);
session.setAttribute("salary",salary);
session.setAttribute("it",incomeTax);
session.setAttribute("percent",percent);
response.sendRedirect("StoreTaxData.jsp");
	
%>