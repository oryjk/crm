<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/17
  Time: 下午4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="/resources/customer-revise/customer-revise.css"/>
  <link rel="stylesheet" href="/resources/core/jq/Jquery-date-and-time/jquery-calendar.css"/>
  <!--<script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js"></script>-->
  <title></title>
</head>
<body>
<!-- header-begin -->
<jsp:include page="header.jsp">
  <jsp:param name="title" value="短信详情"/>
</jsp:include>
<!-- header-end -->
  <h2>用户信息</h2>
  <table class="content-table">
    <tr>
      <th>用户ID:</th>
      <td>${smsInfo.contactId}</td>
    </tr>
    <tr>
      <th>用户名称:</th>
      <td>${smsInfo.contactName}</td>
    </tr>
    <tr>
      <th>手机号码:</th>
      <td>${smsInfo.phone}</td>
  </tr>
  </table>
  <h2>产品信息</h2>
  <table class="content-table">
    <tr>
      <th>产品ID:</th>
      <td>${smsInfo.goodsId}</td>
    </tr>
    <tr>
      <th>产品名称:</th>
      <td>${smsInfo.goodsName}</td>
    </tr>
    <tr>
      <th>产品型号:</th>
      <td>${smsInfo.goodsModel}</td>
    </tr>

    <tr>
      <th>发送短信时间:</th>
      <td><fmt:formatDate value="${smsInfo.sendDate}" pattern="yyyy-MM-dd"/></td>
    </tr>
    <tr>
      <th>发送短信内容:</th>
      <td class="mes-content" style="display: block">${smsInfo.smsContent}</td>
    </tr>
    <tr class="invest-new">
      <th></th>
      <td>
        <a href="/smsInfo/add?id=${smsInfo.id}" class="invest-submit">修改</a>
        <a href="javascript:void(0)" data-value="${smsInfo.id}" id="invest-delete" class="invest-submit delete-btn">删除</a>
      </td>
    </tr>
    <tr>
      <th></th>
      <td>
        <a class="back" href="javascript:history.go(-1);">返回</a>
      </td>
    </tr>
  </table>
  <div id="listSure" class="list-sure" style="display: none">
    <div class="list-sure-title"></div>
    <div class="list-sure-content">
      确认删除信息？
    </div>
    <div class="list-sure-btn">
      <a class="list-sure-btn1" href="javascript:void(0)">确认</a>
      <a class="list-sure-btn2" href="javascript:void(0)">取消</a>
    </div>
  </div>
<script src="/resources/core/jq/jquery-1.11.1.js" ></script>
<script src="/resources/core/jq/Jquery-date-and-time/jquery-calendar.js"></script>
<script src="/resources/customer-list/customer-list.js"></script>
</body>
</html>
