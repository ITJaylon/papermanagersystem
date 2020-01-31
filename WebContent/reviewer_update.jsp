<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿</title>
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
<body >

	<form class="form-horizontal" id="articleAddForm" name="articleAddForm"
		autocomplete="off" action="updateReviewer" method="post">
		<div class="modal-header">
			<button class="close"
				onclick="javascrtpt:window.location.href='login.jsp'">x</button>
			<h3>修改审稿人员</h3>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">稿件编号</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="reviewerId"
						id="reviewerId" value="${reviewer.reviewerId }"
						placeholder="以r字符开头+三位数字编号，如r001" required>
				</div>
				<div class="col-sm-4 tips" id="checkReviewerId">
					<span>* </span>必填
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="reviewerName"
						id="reviewerName" value="${reviewer.reviewerName}"
						placeholder="请输入姓名" required>
				</div>
				<div class="col-sm-4 tips" id="checkWriterName">
					<span>* </span>必填
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="reviewerPasswd"
						id="reviewerPasswd" value="${reviewer.reviewerPasswd}"
						placeholder="请输入密码" required>
				</div>
				<div class="col-sm-4 tips" id="checkWriterName">
					<span>* </span>必填
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">手机号</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="reviewerPhone"
						id="reviewerPhone" value="${reviewer.reviewerPhone}"
						placeholder="请输入手机号" required>
				</div>
				<div class="col-sm-4 tips" id="checkWriterName">
					<span>* </span>必填
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">稿件类型</label> <select
					id="reviewerType" name="reviewerType" id="articleType"
					value="${reviewer.reviewerType }" required>
					<option value="">-请选择审稿方向-</option>
					<option value="文学">文学</option>
					<option value="科技">科技</option>
					<option value="医学">医学</option>
					<option value="教育">教育</option>
					<option value="其他">其他</option>
				</select>
			</div>
			
			<div class="modal-footer">
				<button class="btn btn-primary" id="addArticle-btn" type="submit">保存</button>
				<button class="btn btn-info"
					onclick="javascrtpt:window.location.href='index.jsp'">关闭</button>
			</div>
	</form>
	<script type="text/javascript">
	/* $("#addArticle-btn").click(function(){
		alert("投稿成功！");
	}) */
	
	$("#articleId").change(function() {
		var articleId = this.value;
		if (articleId.substr(0, 1) == 'a') {
			$.ajax({
				url : "Article-exist",
				data : "articleId="+articleId,
				type : "POST",
				success : function(data) {
					if (data == "1") {
						$("#checkArticleId").html("稿件编号可用");
					} else {
						$("#checkArticleId").html("稿件编号已被使用！");
						$("#articleId").val("");
					}
				}
			});
		} else {
			alert("账号必须a开头！如a001");
			$("#articleId").val("");
		}
	});
	</script>





	<script type="text/javascript">

	 
		/* $(function() {		
			$("#addArticle-btn").click(function () {
				
	            $.ajax({
	                url: "insertArticle",
	                type: "post",
	                //.serialize() 当提交多条表单数据时，我们可以采用当表单进行序列化的方式简化原有的操作
	                data:{
	                	"articleId":$("#articleId").val(),
	                	"articleTitle":$("#articleTitle").val(),
	                	"articleType":$("#articleType").val(),
	                	"artitleWriterId":${articleWriterId},
	                	"artitleText":$("#articleText").val()
	                },
	                dataType:"json",
	                success: function (result) {
	                    if (result.toString() == "success") {
	                    	alert("投稿成功！");
	                    } else {
	                    	alert("投稿失败！");
	                    }
	                }
	            })
	        })
		});   */
		
		
		/* function show_validate_msg(ele, status, msg) {
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$("#checkArticleId").html("稿件编号可用");
			} else if ("error" == status) {
				$("#checkArticleId").html("稿件编号已被使用！");
				$("#articleId").val("");
			}
		}  */


	</script>


</body>
</html>
