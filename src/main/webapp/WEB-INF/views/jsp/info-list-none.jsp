<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/17
  Time: 下午2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
    <title></title>
  </head>
  <body>
  <!-- header-begin -->
  <div class="header">
    <jsp:include page="header.jsp">
      <jsp:param name="title" value="短信列表"/>
    </jsp:include>
  </div>
  <!-- header-end -->

  <div class="content-list">
    <div class="list-none">很遗憾，您还没有短信记录哦</div>
  </div>
  </body>
  <script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js" ></script>
  <script src="/resources/customer-list/customer-list.js" ></script>
</html>
