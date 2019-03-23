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
			//执行jquery$ajax
			$.ajax({
				type:'get',
				url:'AjaxServlet01',
				data:{uname:uname},
				success:function(data){
					if(data=='ok'){
						$("#msg").css("color","green");
						$("#msg").text("该账号可以用");
					}else{
						$("#msg").css("color","red");
						$("#msg").text("该账号不可以用");
					}
				}
			});	
		}
	</script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>	
</body>
</html>