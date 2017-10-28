function getServerTime(){
	var ajax=new XMLHttpRequest();
	ajax.open("get","/servertime");
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4){
			var time=ajax.responseText;
			var timeEl =document.getElementById("time");
			timeEl.innerHTML=time;
		}
	}	
	ajax.send();
	
	
}