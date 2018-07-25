<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#dl").click(function () {
			$.post(
				//地址
				"qservlet?mh=login",
				//传值
				$("form").serialize(),
				//返回函数
				function (obj) {
					if(obj=="yes"){
						alert("登录成功");
						location="qservlet?mh=list";
					}else{
						alert("账号密码错误!")
					}
				},
				//返回类型
				"text"
			)
			
		})
	})
</script>
</head>
<body>
<form>
	<table>
		<tr>
			<td>姓名:<input type="text" name="name" ></td>
		</tr>
		<tr>
			<td>密码:<input type="text" name="pwd" ></td>
		</tr>
		<tr>
			<td><input type="button" value="登录"  id="dl" ></td>
		</tr>
	</table>
</form>
</body>
</html>