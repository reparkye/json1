<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//플랫폼(OS)가 기본으로 가지고 있는 사용자의 템프 디렉토리 경로를 가져온다.
String tmpPath = System.getProperty("java.io.tmpdir");
//해당 디렉토리 경로로 템프디렉토리를 설정하기 위해 파일로 만든다.
File tmpDir = new File(tmpPath);
DiskFileItemFactory dFactory = new DiskFileItemFactory();
//디스크파일아이템팩토리의 리파지토지를 위에서 만든 템프디렉토리로 셋팅한다.
dFactory.setRepository(tmpDir);
//RAM사용량을 10MB로 셋팅한다.
dFactory.setSizeThreshold(1024*1024*10);

//request를 파싱할 ServletFileUpload를 만든다.
ServletFileUpload sfu = new ServletFileUpload();
//위에서 만든 디스크파일아이템팩토리를 셋팅해준다.
sfu.setFileItemFactory(dFactory);
//파일 1개당 맥시멈 사이즈를 100MB로 제한한다.
sfu.setFileSizeMax(1024*1024*100);
//1번에 업로드 할수 있는 맥시멈 사이즈를 200MB로 제한한다.
sfu.setSizeMax(1024*1024*200);

//서블릿파일업로드를 이용해서 request를 파싱한다.
List<FileItem> fList = sfu.parseRequest(request);

//저장할 경로를 셋팅한다.
String savePath = "C:/jsp_study/workspace/json/WebContent/files";

for(int i=0;i<fList.size();i++){
	FileItem fi = fList.get(i);
	if(fi.isFormField()){
		//type이 파일이 아닐때!!
		String name = fi.getFieldName();
		String value = fi.getString("utf-8");
		out.println(name +" : " +value + "<br>");
	}else{
		//type이 파일일때!!
		String name = fi.getFieldName();
		String value = fi.getName();
		if(value.equals("")) continue;
		savePath = savePath + File.separator + value;
		File save = new File(savePath);
		fi.write(save);
		out.println(name + " : " + value + "<br>");
	}
}
%>