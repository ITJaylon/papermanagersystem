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
	
						<form class="form-horizontal" autocomplete="off"
							action="updateAccount" method="post">
							<div class="modal-header">
								<button class="close"
									onclick="javascrtpt:window.location.href='accountInfo.jsp'">x</button>
								<h3>账户充值</h3>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">账户号</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="accountId"
											id="accountId" value="${account.accountId }" readonly="true">
									</div>

								</div>	
									
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">账户号</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="accountWriterId"
											id="accountWriterId" value="${account.accountWriterId }" readonly="true">
									</div>

								</div>
								
								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">充值金额</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" name="accountBalance"
											id="accountBalance" placeholder="充值金额" required>
									</div>
									<div class="col-sm-4 tips" id="checkMoney">
										<span>* </span>必填
									</div>
								</div>

								<div class="modal-footer">
									<button class="btn btn-primary" id="reg-btn" type="submit">充值</button>
									<button class="btn btn-info"
										onclick="javascrtpt:window.location.href='index.jsp'">关闭</button>
								</div>
						</form>

					


	<script type="text/javascript">
	
	$("#accountBalance").change(function() {
		var value = $("#accountBalance").val();
		var reg = /-?[1-9]\d*/;
		if (!reg.test(value)) {
			$("#checkMoney").html("输入不正确");
			$("#accountBalance").val("");
		} else{
			$("#checkMoney").html("输入正确");
		}
		if(value<20){
			alert('充值不得小于20！');
			$("#accountBalance").val("");
		}
	});
	</script>


</body>
</html>
