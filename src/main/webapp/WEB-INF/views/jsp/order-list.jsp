<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/21
  Time: 上午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/resources/customer-purchase/customer-purchase.css"/>
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
</head>
<body>
<div class="header">
  <div class="header-content">
    <div class="header-name">
      <span><a onclick="javascript:window.close();" href="#">关闭</a></span>
    </div>
  </div>
  <a href="/contact/list">首页</a>
</div>
<!-- header-end -->
<div class="content-name">

  <div class="content-name-in">客户姓名：<span>${contact.name}</span></div>
  <div class="content-name-phone">联系方式：<span>${contact.mobile}</span></div>
</div>

<table class="content-list">
  <tbody>
    <tr class="list-title">
      <td>商品名称</td>
      <td>销售人员</td>
      <td class="list-time">交易日期</td>
      <td>单价</td>
      <td>数量</td>
      <td>折扣额</td>
      <td>总金额</td>
      <td>短信操作</td>
    </tr>
  </tbody>
  <tbody>
    <c:forEach var="order" items="${orderList}">
      <tr class="list-all">
        <td>
          <span>${order.goodsName}</span>
        </td>
        <td>${order.salesMan}</td>
        <td class="list-time"><fmt:formatDate value="${order.billDate}" pattern="yyyy-MM-dd"/></td>
        <td class="list-red"><span>¥ ${order.price}</span></td>
        <td>${order.quantity}</td>
        <td>¥ ${order.deduction}</td>
        <td>¥ ${order.totalAmount}</td>
        <td>
          <c:choose>
            <c:when test="${order.smsCount<=0}">
              <a href="/smsInfo/add?invoiceId=${order.id}" class="link-btn">添加</a>
            </c:when>
            <c:otherwise>
              <a href="/smsInfo/viewByIid?invoiceId=${order.id}" class="link-btn">查看</a>
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<table class="list-page">
  <tr>
    <c:if test="${pagination.currentPage>1}">
      <td><a href="/order/list?contactId=${contact.id}&currentPage=1">首页</a></td>
      <td><a href="/order/list?contactId=${contact.id}&currentPage=${pagination.currentPage-1}">上一页</a></td>
    </c:if>

    <c:if test="${pagination.totalPage>1}">
      <c:forEach begin="1" end="${pagination.totalPage}" var="i">
        <td><a href="/order/list?contactId=${contact.id}&currentPage=${i}" <c:if test="${i==pagination.currentPage}">class="current-page"</c:if>>${i}</a></td>
      </c:forEach>
    </c:if>
    <c:if test="${pagination.currentPage<pagination.totalPage}">
      <td><a href="/order/list?contactId=${contact.id}&currentPage=${pagination.currentPage+1}">下一页</a></td>
      <td><a href=/order/list?contactId=${contact.id}&currentPage=${pagination.totalPage}>尾页</a></td>
    </c:if>
    <c:if test="${pagination.totalPage>1}">
      <td>共${pagination.totalPage}页</td>
    </c:if>
  </tr>
</table>
</body>
</html>
