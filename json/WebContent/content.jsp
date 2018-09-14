<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String method = request.getMethod();
%>    

<div>
	저는 JSP 파일에서 생성되는 HTML 입니다.	<%=method %>

</div>