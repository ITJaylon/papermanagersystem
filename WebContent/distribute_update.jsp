<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>任务分配</title>
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
	<form class="form-horizontal" autocomplete="off" action="updateDistribute_2"
		method="post">
		<div class="modal-header">
			<button class="close"
				onclick="javascrtpt:window.location.href='index.jsp'">x</button>
			<h3>审稿任务分配</h3>
		</div>
		<div class="modal-body">
			<div class="form-group">

				<div class="col-sm-6">
					<input type="hidden" class="form-control" name="distributeId"
						id="distributeId" value="${distribute.distributeId}" >
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">稿件名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="distributeArticleId"
						id="distributeArticleId" value="${articleMap[distribute.distributeArticleId]}" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">初审人员</label>
				<div class="col-sm-6">
						
					<select id="distributeReviewerId" class="form-control" name="distributeReviewerId" required>
						<option value="">-请选择-</option>						
						<c:forEach items="${reviewerMap}" var="r" >							
							<option value="${r.key}">${r.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">复审人员</label>
				<div class="col-sm-6">
						
					<select id="distributeManagerId" class="form-control" name="distributeManagerId" required>
						<option value="">-请选择-</option>						
						<c:forEach items="${managerMap}" var="m" >							
							<option value="${m.key}">${m.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="modal-footer">
				<button class="btn btn-primary" id="reg-btn" type="submit">提交</button>
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
			} else {
				$("#checkMoney").html("输入正确");
			}
			if (value < 20) {
				alert('充值不得小于20！');
				$("#accountBalance").val("");
			}
		});
	</script>


</body>
</html>
