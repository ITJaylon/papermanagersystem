<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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

<script>
	function init() {
		var value = '${msg}';
		if (null != value && "" != value) {
			alert(value);
		}
	}
</script>
</head>
<body onload='init()'>

	<form class="form-horizontal" autocomplete="off" action="userUpdate"
		method="post">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">x</button>
			<h3>个人信息</h3>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">账号</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="writerId"
						id="writerId" value="${writer.writerId}" readonly="true"
						placeholder="以w字符开头+三位数字编号，如w001"> <label></label>
				</div>
				<!-- <div class="col-sm-4 tips">
					<span>* </span>必填
				</div> -->
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="writerName"
						id="writerName" value="${writer.writerName}" placeholder="请输入姓名"
						required>
				</div>
				<div class="col-sm-4 tips">
					<span>* </span>必填
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="writerPasswd"
						id="writerPasswd" value="${writer.writerPasswd}"
						placeholder="6-18位，至少包含大写、小写字母、数字" required>
				</div>
				<div class="col-sm-4 tips" id="checkWriterPwd">
					<span>* </span>必填
				</div>
			</div>
			<div class="form-group">
				<label for="mobile" class="col-sm-2 control-label">手机号码</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="writerPhone"
						id="writerPhone" value="${writer.writerPhone}"
						placeholder="输入11位手机号码" required>
				</div>
				<div class="col-sm-4 tips" id="checkWriterPhone">
					<span>* </span>必填
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">E-mail</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="writerEmail"
						id="writerEmail" value="${writer.writerEmail}" placeholder="请输入邮箱"
						required>
				</div>
				<div class="col-sm-4 tips" id="checkEmail">
					<span>* </span>必填
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" type="submit">修改</button>
			<button class="btn btn-info" type="button"
				onclick="javascrtpt:window.location.href='index.jsp'">关闭</button>
		</div>

	</form>
	<script type="text/javascript">
		$("#writerEmail")
				.change(
						function() {
							var value = $("#writerEmail").val();
							var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
							if (!reg.test(value)) {
								$("#checkEmail").html("邮箱格式不正确");
								$("#writerEmail").val("");
							} else {
								$("#checkEmail").html("邮箱格式正确");
							}
						});

		$("#writerPasswd").change(function() {
			var value = $("#writerPasswd").val();
			var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/;
			if (!reg.test(value)) {
				$("#checkWriterPwd").html("密码格式不正确");
				$("#writerPasswd").val("");
			} else {
				$("#checkWriterPwd").html("密码格式正确");
			}
		});

		$("#writerPhone").change(function() {
			var value = $("#writerPhone").val();
			var reg = /0?(13|14|15|18|17)[0-9]{9}/;
			if (!reg.test(value)) {
				$("#checkWriterPhone").html("手机格式不正确");
				$("#writerPhone").val("");
			} else {
				$("#checkWriterPhone").html("手机格式正确");
			}
		});
	</script>
</body>
</html>