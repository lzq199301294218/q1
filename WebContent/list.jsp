<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function toupdate(id) {
		location = "update.jsp?id="+id;
	}
	function tj() {
		location="insert.jsp";
	}
	$(function () {
		$("#qx").click(function () {
			$(":checkbox").attr("checked",true);
		})
		$("#qbx").click(function () {
			$(":checkbox").attr("checked",false);
		})
		$("#fx").click(function () {
			$(":checkbox").each(function () {
				if($(this).attr("checked")){
					$(this).attr("checked",false);
				}else{
					$(this).attr("checked",true);
				}
			})
		})
		$("#ps").click(function () {
			var id = "";
			$(".ck:checked").each(function () {
				id+=","+$(this).val();
			})
			id = id.substring(1);
			$.post(
				//地址
				"qservlet?mh=del",
				//传值
				{"id":id},
				//回调函数
				function (obj) {
					if(obj!=0){
						alert("删除成功!");
						location="qservlet?mh=list";
					}else{
						alert("删除失败!");
					}
				},
				//返回值类型
				"text"
			)
		})
	})
</script>
</head>
<body>
<table>
	<tr>
		<td></td>
		<td>编号</td>
		<td>姓名</td>
		<td>密码</td>
		<td>性别</td>
		<td>爱好</td>
		<td>生日</td>
		<td><input type="button" value="添加" onclick="tj()"></td>
	</tr>
	<c:forEach items="${list }" var="list">
	<tr>
		<td><input type="checkbox" value="${list.id }" class="ck"></td>
		<td>${list.id }</td>
		<td>${list.name }</td>
		<td>${list.pwd }</td>
		<td>${list.sex }</td>
		<td>${list.hobby }</td>
		<td>${list.bir }</td>
		<td><input type="button" value="修改" onclick="toupdate(${list.id})"></td>
	</tr>	
	</c:forEach>
	<tr>
		<td><input type="button" value="批量删除" id="ps"></td>
		<td><input type="button" value="全选" id="qx"></td>
		<td><input type="button" value="全不选" id="qbx"></td>
		<td><input type="button" value="反选" id="fx"></td>
	</tr>
</table>
</body>
</html>