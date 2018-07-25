<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function () {
		var id = "${param.id}";
		$.post(
			//地址
			"qservlet?mh=toupdate",
			//传值
			{"id":id},
			//回调
			function (obj) {
				$("[name='id']").val(obj.id);
				$("[name='name']").val(obj.name);
				$("[name='pwd']").val(obj.pwd);
				$("[name='sex'][value='"+obj.sex+"']").attr("checked",true);
				var hobbys = obj.hobby.split(" ");
				for(var i in hobbys){
					$("[name='hobby'][value='"+hobbys[i]+"']").attr("checked",true);
				}
				$("[name='bir']").val(obj.bir);
			},
			//返回值类型
			"json"
		)
		$("#xg").click(function () {
			$.post(
				//地址
				"qservlet?mh=update",
				//传值
				$("form").serialize(),
				//回调函数
				function (obj) {
					if(obj!=0){
						alert("修改成功!");
						location="qservlet?mh=list";
					}else{
						alert("修改失败!");
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
			<td>编号<input type="text" name="id"></td>
		</tr>
		<tr>
			<td>姓名<input type="text" name="name"></td>
		</tr>
		<tr>
			<td>密码<input type="text" name="pwd"></td>
		</tr>
		<tr>
			<td>性别
			<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女
			</td>
		</tr>
		<tr>
			<td>爱好
			<input type="checkbox" name="hobby" value="吃饭">吃饭
			<input type="checkbox" name="hobby" value="睡觉">睡觉
			<input type="checkbox" name="hobby" value="打安狗兴">打安狗兴
			</td>
		</tr>
		<tr>
			<td>生日<input type="text" name="bir" onclick="WdatePicker()" class="Wdate"></td>
		</tr>
		<tr>
			<td><input type="button" value="确认修改" id="xg"></td>
		</tr>
	</table>
</form>
</body>
</html>