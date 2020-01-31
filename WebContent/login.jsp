<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7/css/bootstrap.css" />
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>

<script>
	function init(){
		var value = '${result}';
		if(null!=value && ""!=value){
			alert(value);
		}
	} 	
</script>
<body onload='init()'>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="userLogin" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>在线投稿审稿管理系统</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="userId"
										placeholder="登录账号" data-validate="required:请填写登录账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group" align="center">
								<div class="field field-icon-right">
									<select id="userType" class="form-control"
										data-validate="required:请选择身份信息" name="userType">
										<option value="">-请选择身份-</option>
										<option value="1">投稿员</option>
										<option value="2">审稿员</option>
										<option value="3">管理员</option>
									</select>
								</div>
							</div>
						</div>
						<div style="padding: 30px;" align="center">
							<input type="submit"
								class="button btn-lg bg-main text-big input-big" value="登录">
							<input type="button"
								class="button btn-lg bg-main text-big input-big"
								onclick="location.href='register.jsp'" value="注册">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>