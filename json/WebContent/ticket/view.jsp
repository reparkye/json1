<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <script src="/json/js/AjaxUtil.js"></script>
<body>
	<%=request.getParameter("tmnum") %>
	<table border="1">
		<tr>
			<th>번호 : </th>
			<td data-col="tmnum"></td>
		</tr>
		<tr>
			<th>영화명 : </th>
			<td data-col="tmname"></td>
		</tr>
		<tr>
			<th>개봉일 : </th>
			<td data-col="tmstartdat"></td>
		</tr>
		<tr>
			<th>종영일 : </th>
			<td data-col="tmenddat"></td>
		</tr>
		<tr>
			<th>등록일자 : </th>
			<td data-col="tmcredat"></td>
		</tr>
		<tr>
			<th>관객수 : </th>
			<td data-col="tmcnt"></td>
		</tr>
	</table>
<script>
	<%-- var tmnum = <%=request.getParameter("tmnum")%>;
	window.onload = function(){
		var conf = {url:'/json/api/ticket/view', params:{tmnum:tmnum}, cb:callback};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			var mi = JSON.parse(res);
			var sum = document.querySelectorAll('td[data-col]');
			
			sum.forEach((e) => {
				document.querySelector('td[data-col=' + e.getAttribute('data-col') + ']').innerHTML =mi[e.getAttribute('data-col')];
			});
		}
	} --%>

	var tmnum = <%=request.getParameter("tmnum")%>;
	window.onload = function(){
		var conf = {url:'/json/api/ticket/view',
				params:{tmnum:tmnum},
				cb:callback
				};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res = JSON.parse(res);
			var tds = document.querySelectorAll('td[data-col]');
			for(var td of tds){
				td.insertAdjacentHTML('afterbegin',res[td.getAttribute('data-col')]);
			}
		}
	}

	
</script>	
</body>
