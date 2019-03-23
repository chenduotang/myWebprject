<%@page import="java.util.List"%>
<%@page import="src.com.bdqn.zmj.entity.User"%>
<%@page import="src.com.bdqn.zmj.entity.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{	
		padding:0px;
		margin:0px;
	}
	section{
		width:402px;
		margin:20px auto;
	}
	span.page{
		margin-left:42px;
	}
	table{
		border-collapse:collapse;
		width:400px;
		text-align:center;
		margin-bottom:20px;
	}
	tr{
		height:33px;
	}
	a:link{
		color:blue;
		text-decoration:none;
	}
	a:visited{
		color:orange;
	}
	a:hover{
		color:#FF41FE;
	}
	a:active{
		color:orange;
		text-decoration:underline;
	}
	
</style>
</head>
<body>
	<section>
		<table border="1">
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>
		
		</table>
		<p>
			<c:set var="page" value="${userPage}"></c:set>
			共计<span>${page.totalPage}</span>页，当前为第<span>${page.currentPage }</span>页
			<c:out value=""></c:out>
			<span class="page">
				<a href="?opr=1">首页</a>&nbsp;
				<a href="?opr=${page.currentPage-1==0?page.currentPage:page.currentPage-1 }">上一页</a>&nbsp;
				<a href="?opr=${page.currentPage==page.totalPage?page.totalPage:page.currentPage+1 }">下一页</a>&nbsp;
				<a href="?opr=${page.totalPage}">末页</a>
			</span>
		</p>
	</section>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$.ajax({
		"url" : "UserServlet", 
		"type" : "get",
		"dataType" : "text",
		"success" : showInfo
	});
	function showInfo(){
		var $table = $("table");
		var userList = ${page.data};
		$(userList).each(function(){
			$("table").append("<tr><td>"+this.uid+"</td><td>"+this.uname+"</td><td>"+this.upwd+"</td></tr>");
		});
	}
	$(function(){
		var pageNo = ${page.currentPage};//获取当前页
		var totalCount = ${page.totalPage};//获取总页数
		$("a:eq(1)").click(function(){
			if(pageNo==1){
				alert("已经是第一页了！");
				return false;
			}
		}).next().click(function(){
			if(pageNo==totalCount){
				alert("已经是最后一页了！")
				return false;
			}
		})
	})
</script>
</html>