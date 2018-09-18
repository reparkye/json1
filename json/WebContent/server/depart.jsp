<%@page import="json.Ttpro"%>
<%@page import="json.Ddepart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>  
<%@page import="com.google.gson.Gson"%>
    
<%!
%>

<%
	String param = request.getParameter("params");
	System.out.println(param);
Gson gson = new Gson();

Ddepart d = gson.fromJson(param, Ddepart.class);  //스트링 param을 맵형태로
Ttpro tt = new Ttpro();

out.println(gson.toJson(tt.getInfo(d.getDiname())));
%>

    
    
    
    