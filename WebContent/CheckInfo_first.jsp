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
    <div class="panel-heading">审核列表</div>
    <div class="panel-body">
        <%-- <form  class="navbar-form navbar-left" action="" method="post">
            <div class="form-group">			
                <button type="button" class="btn btn-success" onclick="location.href='article_add.jsp?articleWriterId=${articleWriterId}'">投稿</button>
            </div>
        </form> --%>
    </div>
</div>

<table class="table table-bordered table-striped table-hover">
    <tr>
        <th width="6%" class="label-info">序号</th>
        <th width="6%" class="label-info">稿件名称</th>
        <th width="6%" class="label-info">初审人员</th>
        <th width="6%" class="label-info">初审结果</th>
        <th width="6%" class="label-info">复审人员</th>
        <th width="6%" class="label-info">复审结果</th>
        <th width="6%" class="label-info">操作</th>
    </tr>    
    <c:forEach items="${checkInfoList}" var="a" >
    	<tr>	     
	        <td>${a.checkInfoId}</td>
	        <td>${articleMap[a.articleId]}</td>
	        <td>${reviewerMap[a.reviewerId]}</td>
	        <td>
	        	<c:if test="${a.firstCheckStatus==0}">未通过</c:if>
	        	<c:if test="${a.firstCheckStatus==1}">已通过</c:if>
	        </td>
	        <td>${managerMap[a.managerId]}</td>
	        <td>
	        	<c:if test="${a.secondCheckStatus==0}">未通过</c:if>
	        	<c:if test="${a.secondCheckStatus==1}">已通过</c:if>
	        </td>	
	        <td>
			<a href="firstCheck?checkInfoId=${a.checkInfoId}" class="btn btn-success btn-sm">初审</a>&nbsp;
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