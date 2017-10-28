window.onload=function(){
	var ajax=createAjax();
	ajax.open("get","/cascace?cmd=province");
	var html="<option value='-1'>--请选择---</option>";
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&&ajax.status==200){
			 html += ajax.responseText;
			document.getElementById("province").innerHTML=html;
		}
	}
	ajax.send();
}
function getCityById(){
	var provinceId = document.getElementById("province").value;
	var ajax=createAjax();
	ajax.open("get","/cascace?cmd=city&provinceId="+provinceId);
	var html="<option value='-1'>--请选择---</option>";
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4&&ajax.status==200){
			 html += ajax.responseText;
			document.getElementById("city").innerHTML=html;
		}
	}
	ajax.send();
}
function createAjax(){
	var ajax;
	try{//非IE浏览器
		ajax=new XMLHttpRequest();
		
	}catch(e){
		ajax=new ActiveXObject();
	}
	return ajax;
}