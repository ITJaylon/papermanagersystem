<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>复审</title>
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
	<form class="form-horizontal" autocomplete="off" action="firstCheck_2"
		method="post">
		<div class="modal-header">
			<button class="close"
				onclick="javascrtpt:window.location.href='index.jsp'">x</button>
			<h3>复审</h3>
		</div>
		<div class="modal-body">
			<div class="form-group">

				<div class="col-sm-6">
					<input type="hidden" class="form-control" name="checkInfoId"
						id="checkInfoId" value="${checkInfo.checkInfoId}">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">稿件名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="articleId"
						id="articleId" value="${articleMap[checkInfo.articleId]}"
						readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">稿件内容</label>
				<div class="col-sm-6">
					<textarea rows="50%" cols="30%" class="form-control"
						name="articleText" id="articleText"
						value="" readonly="true">${article.articleText }</textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">审核结果</label>
				<div class="col-sm-6">
					<select id="firstCheckStatus" class="form-control"
						data-validate="required:请选择身份信息" name="firstCheckStatus">
						<option value="">-请选择-</option>
						<option value="0">不通过</option>
						<option value="1">通过</option>

					</select>

				</div>
			</div>


			<div class="modal-footer">
				<button class="btn btn-primary" id="reg-btn" type="submit">提交</button>
				<button class="btn btn-info"
					onclick="javascrtpt:window.location.href='index.jsp'">关闭</button>
			</div>
	</form>


</body>
</html>
