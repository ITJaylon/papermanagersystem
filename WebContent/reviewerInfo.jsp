<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">

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
    <div class="panel-heading">稿件列表</div>
    <div class="panel-body">
        <form  class="navbar-form navbar-left" action="" method="post">
            <div class="form-group">			
                <button type="button" class="btn btn-success" onclick="location.href='reviewer_add.jsp'">新增审稿人</button>
            </div>
        </form>
    </div>
</div>

<table class="table table-bordered table-striped table-hover">
    <tr>
        <th width="6%" class="label-info">审稿人编号</th>
        <th width="10%" class="label-info">审稿人姓名</th>
        <th width="6%" class="label-info">密码</th>
        <th width="6%" class="label-info">手机号</th>
        <th width="10%" class="label-info">审稿类型</th> 
        <th width="10%" class="label-info">操作</th>
    </tr>    
    <c:forEach items="${reviewerList}" var="r" >
    	<tr>	     
	        <td>${r.reviewerId}</td>
	        <td>${reviewerMap[r.reviewerId]}</td>
	        <td>${r.reviewerPasswd}</td>
	        <td>${r.reviewerPhone}</td>
	        <td>${r.reviewerType}</td>  
	        <td>
	        	<a href="reviewer_update?reviewerId=${r.reviewerId}" class="btn btn-success btn-sm">修改</a>&nbsp;
	        	<a href="reviewer_delete?reviewerId=${r.reviewerId}" class="btn btn-danger btn-sm">删除</a>&nbsp;	             
    		</td>
    	</tr>    	
    </c:forEach>   
</table>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
<script type="text/javascript" src="bootstrap-3.3.7/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>

</html>