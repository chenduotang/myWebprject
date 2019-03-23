<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form style="width: 390px">
		<fieldset>
			<legend>用户注册</legend>
			账号:<input type="text" name="username" onblur="val(this)"><span id="msg"></span><br>
		</fieldset>
	</form>
	<script type="text/javascript">
		function val(obj) {
			var uname = obj.value.trim();
			alert(uname);
			if (uname == null || uname.length < 1) {
				return false;//当输入框为空的时候什么都不做
			}
				//执行ajax
				//1.创建XMLHttpRequest对象
				request=createXmlHttpRequest();
				//2.设置回调函数 
				request.onreadystatechange=callBack;
				//3.设置
				//发送请求到后台
				request.open("get","AjaxServlet01?uname="+uname,true);
				request.send();
		}
		function callBack(){
			if(request.readyState==4 && request.status == 200){
				//代表相应成功获取数据
				var data=request.responseText;
				if(data=='ok'){
					$("#msg").css("color","green");
					$("#msg").text("改账号可以用");
				}else{
					$("#msg").css("color","red");
					$("#msg").text("改账号不可以用");
				}
			}
		}
		function createXmlHttpRequest(){
			if(window.XMLHttpRequest){
				//高版本浏览器
				return new XMLHttpRequest();
			}else{
				//低版本浏览器
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	</script>
</body>
</html>