<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="json.Ttpro"%>
<%@page import="json.DepartIn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="json.Person"%>
<%@page import="com.google.gson.Gson"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>  

<%!

%>    

<%

	String param = request.getParameter("param");
	Gson gson = new Gson();

	DepartIn d = gson.fromJson(param, DepartIn.class);
	
	Map<String,String> pMap = gson.fromJson(request.getReader(), Map.class);
	
	System.out.println(pMap);
	
	Ttpro t = new Ttpro();
	
	List<DepartIn> dList = new ArrayList<DepartIn>();
	
	if(pMap == null){
		dList = t.getInfo(null);	
	} else {
		dList = t.getInfo(pMap.get("sch"));	
	}
	
	System.out.println(dList);
	out.println(dList);
	 
%>    
    
<%-- <%
	Gson gson = new Gson();
	DepartIn d = gson.fromJson(request.getReader(), DepartIn.class);
	
	Connection con = DBCon.getCon();
	String sql = "select * from depart_info";
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = 





%>    
     --%>
    
    
    
    
    
    
    
    
