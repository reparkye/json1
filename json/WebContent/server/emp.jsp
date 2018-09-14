<%@page import="json.Emp"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!

%>    

<%
String param = request.getParameter("param");
Gson gson = new Gson();

Emp e = gson.fromJson(param, Emp.class);
System.out.println(e);
out.println(e);

%>    