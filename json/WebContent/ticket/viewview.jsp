<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<script src = "/json/js/AjaxUtil.js"></script>
<body>
	<%=request.getParameter("tmnum") %>
	<table border="1">
		<tr>
			<th>��ȣ :</th>
			<td data-col="tmnum"></td>
		</tr>
		<tr>
			<th>��ȭ�� :</th>
			<td data-col="tmname" ></td> 
		</tr>
		<tr>
			<th>������ :</th>
			<td data-col="tmstartdat" ></td>
		</tr>
		<tr>
			<th>������ :</th>
			<td data-col="tmenddat"></td>
		</tr>	
		<tr>
			<th>������� :</th>
			<td data-col="tmcredat"></td>
		</tr>
		<tr>
			<th>������ :</th>
			<td data-col="tmcnt"></td>
		</tr>
		<tr>
			<td colspan="2"><button name="delete">����</button></td>
			<td colspan="2"><button name="update">����</button></td>
		</tr>				
	</table>
<script>
	String.prototype.replaceAll = function(str1,str2){
		return this.split(str1).join(str2);
	}

	var tmnum = <%=request.getParameter("tmnum")%>;
	window.onload = function(){
		var conf = {url:'/json/api/ticket/view',params:{tmnum:tmnum}, cb:callback};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res = JSON.parse(res);
			var tds =document.querySelectorAll('td[data-col]');
			for(var tt of tds){
				tt.insertAdjacentHTML('afterbegin',res[tt.getAttribute('data-col')]);
			}
		}
	}

	
	document.querySelector('button[name=delete]').onclick = function(){
		var conf = {url:'/json/api/ticket/delete', method:'DELETE',params:{tmnum:tmnum},cb:callback};
		var au = new AjaxUtil(conf);
		au.send();
		
		function callback(res){
			res = JSON.parse(res);
			
			if(res.rCnt == 1){
				alert("okok");
				location.href="/json/ticket/list.html";
			}else{
				alert("nonono");
			}
		}
	}



</script>
</body>
</html>