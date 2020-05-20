<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h2>测试数组传参</h2>
	<form enctype="application/x-www-form-urlencoded"
	action="${pageContext.request.contextPath}/complex/array" 
	method="post">
		爱好:
		<input type="checkbox" name="hobby" value="唱歌"> 唱歌
		<input type="checkbox" name="hobby" value="踢球"> 踢球
		<input type="checkbox" name="hobby" value="看书"> 看书
		<br>
		<input type="submit"  value="测试数组传参" />
	</form>
	<hr>
	<form enctype="application/x-www-form-urlencoded"
	action="${pageContext.request.contextPath}/complex/list" 
	method="post">
		爱好:
		<input type="checkbox" name="hobbyList" value="唱歌"> 唱歌
		<input type="checkbox" name="hobbyList" value="踢球"> 踢球
		<input type="checkbox" name="hobbyList" value="看书"> 看书
		<br>
		<input type="submit"  value="测试list集合传参" />
	</form>
	
	<hr>
	<button id="testMap" type="button">测试Map传参</button>
	
	<hr>
	<button onclick="jsonToMap()" type="button">测试json转map传参</button>
	<hr>
	<button onclick="jsonToList()" type="button">测试json转list传参</button>
	<hr>
	<button onclick="jsonToBean()" type="button">测试json转Java Bean传参</button>
	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		const path = "${pageContext.request.contextPath}"
		$(function(){
			$('#testMap').click(()=>{
				$.ajax({
					url:path + '/complex/map',//请求路径
					type:'post', //请求方法类型post
					dataType:'text', //数据返回类型
					data:"stuMap['id']=1&stuMap['name']=etoak", //传入的数据
					success:function(data){ //接收返回数据
						alert(data);
					}
				});
			})
		})
		function jsonToMap(){
			//js对象
			let obj = {id:1,name:"etoak"};
			$.ajax({
				url:path +'/json/jsonToMap',
				type:'post',
				data:JSON.stringify(obj),
				dataType:'json',
				contentType:'application/json;charset=utf-8',
				success:function(res){
					alert(res.msg);
				}
			})
		}
		//json转换成list
		function jsonToList(){
			let array = [{id:2,name:"etoak",age:200}];
			let user = {id:1,name:"etoak",age:20};
			array.push(user);
			$.ajax({
				url:path +'/json/jsonToList',
				type:'post',
				data:JSON.stringify(array),
				dataType:'json',
				contentType:'application/json;charset=utf-8',
				success:function(res){
					alert(res.code + "-" + res.msg);
				}
			})
		}
		
		function jsonToBean(){
			let obj = {
					id:1,
					name:"etoak",
					age:20,
					hobbyList:['看书','爬山'],
					stuMap:{id:2,score:200}
			};
			$.ajax({
				url:path + '/json/jsonToBean',
				type:'post',
				data:JSON.stringify(obj),
				dataType:'json',
				contentType:'application/json;charset=utf-8',
				success:function(res){
					alert(res.code + ":" + res.msg);
				}
			});
		}
	</script>
</body>
</html>