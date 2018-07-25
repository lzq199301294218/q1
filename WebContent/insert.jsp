<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function () {
		$("#qrtj").click(function () {
			$.post(
				//地址
				"qservlet?mh=insert",
				//传参
				$("form").serialize(),
				//回调函数
				function (obj) {
					if(obj!=0){
						alert("添加成功!");
						location="qservlet?mh=list"
					}else{
						alert("添加失败!")
					}
				},
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
		<td>姓名:<input type="text" name="name"></td>
	</tr>
	<tr>
		<td>密码:<input type="text" name="pwd"></td>
	</tr>
	<tr>
		<td>性别:
		<input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女
		</td>
	</tr>
	<tr>
		<td>
		爱好:
		<input type="checkbox" name="hobby" value="吃饭">吃饭
		<input type="checkbox" name="hobby" value="睡觉">睡觉
		<input type="checkbox" name="hobby" value="打安狗兴">打安狗兴
		</td>
	</tr>
	<tr>
		<td>生日:<input type="text" name="bir" onclick="WdatePicker()" class="Wdate"></td>
	</tr>
	<tr>
		<td><input type="button" value="确认添加" id="qrtj"></td>
	</tr>
</table>
</form>
</body>
</html>