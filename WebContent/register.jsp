<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿人注册</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7/css/bootstrap.css" />
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<style type="text/css">
.modal-header {
	padding: 0;
}
/*.modal-content{border-radius: 0;}*/
.modal-dialog .close {
	position: absolute;
	top: 10px;
	right: 15px;
}

.modal-dialog h3 {
	font-size: 14px;
	height: 42px;
	line-height: 42px;
	margin: 0;
	padding: 0 80px 0 20px;
}

.modal-dialog label {
	font-weight: 400;
}

.tips {
	line-height: 34px;
	font-size: 13px;
}

.tips span {
	color: red;
}

@media ( min-width : 1080px) {
	/*模态框-距顶部距离*/
	.modal-dialog {
		margin-top: 100px;
	}
	.col-sm-6 {
		padding-left: 0;
		padding-right: 0;
	}
}
</style>
</head>
<body>
	<!--模态框-->
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<div class="modal-dialog">
					<div class="modal-content">
						<form class="form-horizontal" 
							autocomplete="off" action="insertWriter" method="post">
							<div class="modal-header">
								<button class="close"
									onclick="javascrtpt:window.location.href='login.jsp'">x</button>
								<h3>注册个人信息</h3>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">账号</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="writerId" id="writerId" value="${writer.writerId }"
											placeholder="以w字符开头+三位数字编号，如w001"  required> 
									</div>
									<div class="col-sm-4 tips" id="checkWriterId">
										<span>* </span>必填
									</div>
								</div>
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">用户名</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="writerName" id="writerName" "
											 placeholder="请输入姓名" required>
									</div>
									<div class="col-sm-4 tips"  id="checkWriterName">
										<span>* </span>必填
									</div>
								</div>
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">密码</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" name="writerPasswd" id="writerPasswd"
											 placeholder="6-18位，至少包含大写、小写字母、数字" required>
									</div>
									<div class="col-sm-4 tips"  id="checkWriterPwd">
										<span>* </span>必填
									</div>
								</div>
								
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">确认密码</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" id="checkPasswd"
											value="" placeholder="请输入确认密码" required>
									</div>
									<div class="col-sm-4 tips"  id="checkPwd">
										<span>* </span>必填
									</div>
								</div>
								
								<div class="form-group">
									<label for="mobile" class="col-sm-2 control-label">手机号码</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="writerPhone" id="writerPhone"
											placeholder="输入11位手机号码" required
											>
									</div>
									<div class="col-sm-4 tips"  id="checkWriterPhone">
										<span>* </span>必填
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-sm-2 control-label">E-mail</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="writerEmail" id="writerEmail"
											 placeholder="请输入邮箱" required> 
									</div>
									<div class="col-sm-4 tips" id="checkEmail">
										<span>* </span>必填
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button class="btn btn-primary" id="reg-btn" type="submit">保存</button>
								<button class="btn btn-info"
									onclick="javascrtpt:window.location.href='login.jsp'">关闭</button>
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	
	<script type="text/javascript">
		$(function() {
			window.top.parent.dropdownFun();
			//函数dropdownFun()为官方文档中的$(‘#dropdown’).on('show.bs.dropdown', function(){ ··· ··· })
		});

		function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$("#checkWriterId").html("账号可用");
			} else if ("error" == status) {
				$("#checkWriterId").html("账号已被注册！");
				$("#writerId").val("");
			}
		}
		
		$("#writerId").change(function() {
			var writerId = this.value;
			if(writerId.substr(0,1) == 'w' ){
				$.ajax({
					url : "writer-exist",
					data : "writerId=" + writerId,
					type : "POST",
					success : function(data) {
						if (data == "1") {
							show_validate_msg("#writerId", "success", "账号可用");

						} else {
							show_validate_msg("#writerId", "error", "账号已被注册！");
						}
					}
				});
			}else{
				alert("账号必须w开头！如w001");
				$("#writerId").val("");
			}
			
		});
		
		$("#writerEmail").change(function() {
			var value = $("#writerEmail").val();
			var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if (!reg.test(value)) {
				$("#checkEmail").html("邮箱格式不正确");
				$("#writerEmail").val("");
			} else{
				$("#checkEmail").html("邮箱格式正确");
			}
		});
		
		$("#writerPasswd").change(function() {
			var value = $("#writerPasswd").val();
			var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/;
			if (!reg.test(value)) {
				$("#checkWriterPwd").html("密码格式不正确");
				$("#writerPasswd").val("");
			} else{
				$("#checkWriterPwd").html("密码格式正确");
			}
		});
		
		$("#checkPasswd").change(function() {
			var value2 = $("#checkPasswd").val();
			var value1 = $("#writerPasswd").val();
			if(value2 != value1){
				$("#checkPwd").html("两次密码输入不一致！");
				$("#checkPasswd").val("");
			}else{
				$("#checkPwd").html("两次密码输入一致！");
			}
		});
		
		$("#writerPhone").change(function() {
			var value = $("#writerPhone").val();
			var reg = /0?(13|14|15|18|17)[0-9]{9}/;
			if (!reg.test(value)) {
				$("#checkWriterPhone").html("手机格式不正确");
				$("#writerPhone").val("");
			} else{
				$("#checkWriterPhone").html("手机格式正确");
			}
		});
	</script>


</body>
</html>
