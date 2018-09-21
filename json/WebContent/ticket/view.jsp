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
	<tr>	
		<td colspan="1"><button name="delete">삭제</button></td>
		<td data-but="button" colspan="1"><button name="update">수정</button></td>
	</tr>
	</table>
<script>
	
	String.prototype.replaceAll = function(str1,str2){
		return this.split(str1).join(str2);
	}

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
			var tds = document.querySelectorAll('td[data-col]'); //전부 받아옴
			for(var td of tds){
				td.insertAdjacentHTML('afterbegin',res[td.getAttribute('data-col')]);
			}
		}
	}
	
	
	
	document.querySelector('button[name=delete]').onclick = function(){
		var conf = {url:'/json/api/ticket/delete',method:'DELETE',params:{tmnum:tmnum},cb:callback}; //params를 왜 tmnum (where) 으로 하였는지  딜리트라 하나 삭제 위해????
		
		var au = new AjaxUtil(conf);	// 
		au.send();
		
		function callback(res){
			res = JSON.parse(res);
			
			if(res.rCnt == 1){
				alert("ㅇㅋㄷㅋ");
				location.href="/json/ticket/list.html";
			}else{
				alert('안됨 다시');
			}
		}
		
		}
		
	document.querySelector('button[name=update]').onclick = function(){
		
		var conf = {url:'/json/api/ticket/view',params:{tmnum:tmnum},cb:callback};   //view 를 거치는 이유는 아마도 전체 보고나서 수정 위해??
		
		var au = new AjaxUtil(conf);	
		au.send();
		
		function callback(res){
			
			var mi = JSON.parse(res);
			
			var datas = document.querySelectorAll('td[data-col]');
			
			for(var d of datas){
				if(d.getAttribute('data-col').indexOf('dat') > 0 && d.getAttribute('data-col').indexOf('cre') == -1){		//data-col어트리뷰트는 	"tmnum" 값출력후 인덱스오브로 위치 찾는다.	
					d.innerHTML = '<input type="date" name="' + d.getAttribute('data-col') + '">';	
				}else if(d.getAttribute('data-col').indexOf('price') > 0 || d.getAttribute('data-col').indexOf('cnt') > 0){
					d.innerHTML = '<input type="number" name="' + d.getAttribute('data-col') + '" value="' + mi[d.getAttribute('data-col')] + '">';
				}else if(d.getAttribute('data-col').indexOf('num') == -1 && d.getAttribute('data-col').indexOf('cre') == -1){
					d.innerHTML = '<input type="text" name="' + d.getAttribute('data-col') + '" value="' + mi[d.getAttribute('data-col')] + '">';		//value 쓴이유는 수정할때 첫값을 알기위해
				}
			}
			document.querySelector('td[data-but]').innerHTML = '<button onclick="save()">저장하기</button>';
		}
		
	}
	
	function save(){
		var tmname = document.querySelector('input[name=tmname]').value;
		var tmstartdat = document.querySelector('input[name=tmstartdat]').value;
		var tmenddat = document.querySelector('input[name=tmenddat]').value;
		 var tmcnt = document.querySelector('input[name=tmcnt]').value; 
		
		var params = {tmnum:tmnum, tmname:tmname,
				tmstartdat:tmstartdat.replaceAll('-',''), tmenddat:tmenddat.replaceAll('-',''), tmcnt:tmcnt};
		
		var conf = ({url:'/json/api/ticket/update',
					method:'POST',
					params:params,
					cb:callback
				});
		
		var au = new AjaxUtil(conf);
		au.send();
		
		function callback(res){
			res = JSON.parse(res);
			if(res.rCnt == 1){
				alert('업데이트 ㅇㅋ');
				location.href="/json/ticket/list.html";
			}else{
				alert('다시 업데이트 설정');
			}
		}
		
	}
	
	
	
	/* 
	function updateTicket(){
		var tmnum = document.querySelector('data-col[tmnum]');
		var tmname = document.querySelector('data-col[tmname]');
		var tmstartdat = document.querySelector('data-col[tmstartdat]');
		var tmenddat = document.querySelector('data-col[tmenddat]');
		var tmcredat = document,querySelector('data-col[tmcredat]');
		var tmcnt = document.querySelector('date-col[tmcnt]');
		
		var params = {tmnum:tmnum, tmname:tmname, tmstartdat:tmstartdat.replaceAll('-',''),
				tmenddat:tmenddat.replaceAll('-',''),tmcredat:tmcredat,tmcnt:tmcnt};
		
		var conf = {url:'/json/api/ticket/',method:'POST',params:params,cb:callback}
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res = JSON.parse(res);
			if(res.rCnt==1){
				alert('ㅇㅋ');
				location.href="/json/ticket/list.html";
				return;
			}
			alert('업데이트 실패');
		}
		
	}
	 */
	
</script>	
</body>
