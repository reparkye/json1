/**
 * 		
 * 
 * 
 */
		var AjaxUtil = function(conf){
		var method = conf.method?conf.method:'GET';
		var url = conf.url;
		var params = conf.params;
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
		
		var xhr = new XMLHttpRequest();
		
		xhr.cb = callback;
		xhr.err = errback;	
		
		 xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				//alert(xhr.status);		// 알람 확인 입력
				if(xhr.status == 200){
					this.cb(xhr.response);			
				}else{
					this.err(xhr.response);
				}
			}
		}	
		this.send = function(){			//외부호출
		if(method=='GET'){
			url += '?params=' + encodeURIComponent(JSON.stringify(params));
		}
		xhr.open(method,url);
		xhr.send(params);
		}
		
	}		
	 
	
	 