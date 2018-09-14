<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="json.Person"%>
<%@page import="java.util.Map"%>  
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

%>
<%
Gson gson = new Gson();
Person p = gson.fromJson(request.getReader(), Person.class);  //스트링 param을 맵형태로

List<Person> pList = new ArrayList<Person>();

for(int i=1; i<=10; i++){
	p = new Person();
	p.setId("id" + i);
	p.setPassword("비밀번호"+i);
	p.setName("이름" + i);
	p.setTrans(((i%2)+1)+"");
	pList.add(p);
}

out.println(gson.toJson(pList));
%>






