<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/22
  Time: 上午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/resources/customer-purchase/customer-purchase.css"/>
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
</head>
<body>
<!-- header-begin -->
<jsp:include page="header.jsp">
    <jsp:param name="title" value="客户购买列表"/>
</jsp:include>
<!-- header-end -->

<div class="content-list">
  <div class="list-none">很遗憾，您还没有交易记录哦</div>
</div>
</body>
<script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js" ></script>
<script src="/resources/customer-list/customer-list.js"></script>
</html>
