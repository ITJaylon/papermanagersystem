<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function init(){
		var value = '${msg}';
		if(null!=value && ""!=value){
  			alert(value);
  		}
	}
</script>
<body onload='init()'>
<div class="panel panel-info">
    <div class="panel-body">
        <h1>欢迎来到在线投稿审稿管理系统</h1>
    </div>
</div>
	
</body>
</html>