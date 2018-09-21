/**
 * 		
 * 
 * 
 */
		var AjaxUtil = function(conf){
		var method = conf.method?conf.method:'GET';
		var url = conf.url;
		var params = conf.params?JSON.stringify(conf.params):'';		//스트링으로 변한 {"page":"pi"}
		var type = conf.type?conf.type:'json';
		
		//alert("2");
		var comErr = function(res){
			alert(res);
		}
		var comCb = function(res){
			alert(res);
		}	
		
		var callback = conf.cb?conf.cb:comCb;
		var errback = conf.err?conf.err:comErr;
		
		var xhr = new XMLHttpRequest();		//XMLHttpRequest 는 서버와 통신하기 위해 사용
		
		xhr.cb = callback;
		xhr.err = errback;	
		
		 xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){		//0~4까지있는데  send 하는순간0 서버가 받으면1, 파라미터 등읽으면 2 ,알려주는것이(처리끝나면) 3, 끊었을떄 혹은 완료 4
				//alert(xhr.status);		// 알람 확인 입력
				if(xhr.status == 200){		//서로 만족하면 200
					this.cb(xhr.response);			
				}else{
					this.err(xhr.response);
				}
			}
		}	
		this.send = function(){			//외부호출
		if(method=='GET'){
			url += '?params=' + encodeURIComponent(params);
		}
		xhr.open(method,url);		//폰에 전화번호를 적은것 까지
		xhr.send(params);			//전송
		}
		
	}		
	 
	
	 