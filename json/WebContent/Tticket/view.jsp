<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/json/js/AjaxUtil.js"></script>
<body>
<%=request.getParameter("tmnum") %>
<table border="1">
<tr>
	<th>번호</th>
	<td data-col="tmnum"></td>
</tr>
<tr>
	<th>영화명 :</th>
	<td><input type="text" name="tmname" data-col="tmname"></td>
</tr>
<tr>	
	<th>가격</th>
	<td><input type="text" name="tmprice" data-col="tmprice"></td>
</tr>
<tr>
	<th>개봉일</th>
	<td><input type="text" name="tmstartdat" data-col="tmstartdat"></td>
</tr>
<tr>
	<th>종영일:</th>
	<td><input type="text" name="tmenddat" data-col="tmenddat"></td>
</tr>
<tr>
	<th>등록일자:</th>
	<td data-col="tmcredat"></td>
</tr>
<tr>
	<th>관객수</th>
	<td data-col="tmcnt"></td>
</tr>
</table>

<button type="button" onclick="deleteTticket()">삭제</button>
<button type="button" onclick="updateTticket()">수정</button>


<script>
var tmnum = <%=request.getParameter("tmnum")%>

window.onload = function(){
	var conf = {url:'/json/aap/tticket/view',params:{tmnum:tmnum},cb:callback};
	var au = new AjaxUtil(conf);
	au.send();
	
	function callback(res){
		var inpu = document.querySelectorAll('input[data-col]');
		var tds = document.querySelectorAll('td[data-col]');
		
		res = JSON.parse(res);
		
		for(var inp of inpu){
			inp.value = res[inp.getAttribute('data-col')];
		}
		for(var td of tds){
			td.insertAdjacentHTML('afterbegin',res[td.getAttribute('data-col')]); //단일?
			}
	}
}

function updateTticket(){
	var tmname = document.querySelector('input[name=tmname]').value;
	var tmprice = document.querySelector('input[name=tmprice]').value;
	var tmstartdat = document.querySelector('input[name=tmstartdat]').value;
	var tmenddat = document.querySelector('input[name=tmenddat]').value;
	
	var params={tmnum:tmnum,tmname:tmname,tmprice:tmprice,tmstartdat:tmstartdat,tmenddat:tmenddat};
	var conf={url:'/json/aap/tticket/update', params:params,method:'PUT',cb:callback};
	var au = new AjaxUtil(conf);
	au.send();
	
	function callback(res){
		res = JSON.parse(res);
		if(res.rCnt==1){
			alert("ㅇㅋ");
			location.href="/json/Tticket/list.html";
			return;
		}else{
			alert("처리 실패");
		}
	}
}

	function deleteTticket(){
		var params={tmnum:tmnum};
		var conf={url:'/json/aap/tticket/delete',params:params,method:'DELETE',cb:callback};
		var au = new AjaxUtil(conf);
		au.send();
		
		function callback(res){
			res = JSON.parse(res);
			if(res.rCnt==1){
				alert("ㅇㅋ");
				location.href="/json/Tticket/list.html";
				return;
			}else{
				alert("처리 실패");
			}
		}
	}
	</script>
	</body>
	