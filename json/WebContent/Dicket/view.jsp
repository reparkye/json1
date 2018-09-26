<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src=AjaxUtil.js></script>    
 <body>   
<%=request.getParameter("param") %>
<table border="1">
	<tr>
		<th>번호</th>
		<td data-col="tmnum"></td>
	</tr>
	<tr>
		<th>영화명</th>
		<td><input type="text" name="tmname" data-col="tmname"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="text" name="tmprice" data-col="tmprice"></td>
	</tr>
	<tr>
		<th>개봉일</th>
		<td data-col="tmstartdat"></td>
	</tr>

</table>    

<button type="button" onclick="updateDicket"></button>
<button type="button" onclick="deleteDicket"></button>

<script>
var tmnum = <%=request.getParameter("tmnum")%>

window.onload = function(){
	var conf={url:'fdsf',params:{tmnum:tmnum},cb:callback};
	var au = new AjaxUtil(conf);
au.send();

	function callback(res){
		var idcs = document.querySelectorAll('input[data-col]');
		var tds = document.querySelectorAll('td[data-col]');
		
		res = JSON.parse(res);
		
		for(var idc of idcs){
			idc.value = res[idc.getAttribute('data-col')];
		}
		
		for(var td of tds)
			td.insertAdjacent('afterbegin',res[td.getAttribute('data-col')]);
	}
	}
}







	</script>

</body>