<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/22
  Time: 上午11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/resources/user-list/user-list.css"/>
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
</head>
<body>
<!-- header-begin -->
<jsp:include page="header.jsp">
  <jsp:param name="title" value="客户列表"/>
</jsp:include>
<!-- header-end -->

<div class="content">
  <div class="content-head">
    <div class="content-searchBox">
      <form action="/contact/list" method="get">
        <input name="term" class="content-search" type="search" placeholder="${term}">
        <button class="content-search-btn" type="submit"></button>
      </form>
    </div>
  </div>
  <table class="content-list">
    <tr class="list-title">
      <td style="width: 100px;" class="list-first">客户名称</td>
      <td style="width: 50px;">客户编号</td>
      <td style="width: 100px;">手机</td>
      <td style="width: 100px;">座机</td>
      <td style="width: 100px;">客户类别</td>
      <td style="width: 100px;">客户等级</td>
      <td style="width: 250px;">地址</td>
      <td style="width: 100px;">查看购买记录</td>
    </tr>
    <c:forEach items="${contactList}" var="contact" varStatus="index">
      <c:choose>
        <c:when test="${index.count%2!=0}">
          <tr class="list-top">
        </c:when>
        <c:otherwise>
          <tr class="list-bottom">
        </c:otherwise>
      </c:choose>
      <td>${contact.name}</td>
      <td>${contact.number}</td>
      <td>${contact.mobile}</td>
      <td>${contact.phone}</td>
      <td>${contact.category}</td>
      <td>${contact.level}</td>
      <td>${contact.address}</td>
      <td>
        <a class="look-buy-list" href="/order/list?contactId=${contact.id}">查看</a>
      </td>
    </tr>
    </c:forEach>
  </table>
  <table class="list-page">
    <tr>
      <c:if test="${pagination.currentPage>1}">
        <td><a href="/contact/list?term=${term}&currentPage=1">首页</a></td>
        <td><a href="/contact/list?term=${term}&currentPage=${pagination.currentPage-1}">上一页</a></td>
      </c:if>

      <c:if test="${pagination.totalPage>1}">
        <c:forEach begin="1" end="${pagination.totalPage}" var="i">
          <td><a <c:if test="${i==pagination.currentPage}">class="current-page"</c:if> href="/contact/list?term=${term}&currentPage=${i}">${i}</a></td>
        </c:forEach>
      </c:if>
      <c:if test="${pagination.currentPage<pagination.totalPage}">
        <td><a href="/contact/list?term=${term}&currentPage=${pagination.currentPage+1}">下一页</a></td>
        <td><a href=/contact/list?term=${term}&currentPage=${pagination.totalPage}>尾页</a></td>
      </c:if>
      <c:if test="${pagination.totalPage>1}">
        <td>共${pagination.totalPage}页</td>
      </c:if>
    </tr>
  </table>
</div>
</body>
<script src="/resources/customer-list/customer-list.js"/>
</html>
