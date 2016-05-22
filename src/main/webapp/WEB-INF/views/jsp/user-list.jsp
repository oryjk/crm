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
    <link rel="stylesheet" href="/resources/user-list/user-list.scss"/>
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
</head>
<body>
<!-- header-begin -->
<div class="header">
  <div class="header-content">
    <h1>客户管理</h1>

    <div class="header-logout">
      <a href="#">退出 >></a>
    </div>
  </div>
</div>
<!-- header-end -->

<div class="content">
  <div class="content-head">
    <div class="home-btn-box">
      <a class="home-btn" href="/contact/list">首页</a>
    </div>
    <div class="content-searchBox">
      <form action="/contact/list" method="get">
        <input class="content-search" type="search" placeholder="${term}">
        <button class="content-search-btn" type="submit"></button>
      </form>
    </div>
  </div>
  <table class="content-list">
    <tr class="list-title">
      <td>客户名称</td>
      <td>客户编号</td>
      <td>手机</td>
      <td>座机</td>
      <td>查看购买记录</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${contactList}" var="contact">
    <tr class="list-top">
      <td>${contact.name}</td>
      <td>${contact.number}</td>
      <td>${contact.mobile}</td>
      <td>${contact.phone}</td>
      <td>
        <a class="look-buy-list" href="/order/list?contactId=${contact.id}">查看</a>
      </td>
      <td>
        <a class="list-delete delete-btn" href="javascript:void(0)" data-value="${contact.id}">删除</a>
      </td>
    </tr>
    </c:forEach>
  </table>
  <table class="list-page">
    <tr>
      <c:if test="${pagination.currentPage>1}">
        <td><a href="/contact/list?term=${term}&currentPage=1">首页</a></td>
        <td><a href="/contact/list?term=${term}&currentPage=${currentPage-1}">上一页</a></td>
      </c:if>

      <c:forEach begin="1" end="${pagination.totalPage}" var="i">
        <td><a href="/contact/list?term=${term}&currentPage=${i}">${i}</a></td>
      </c:forEach>
      <c:if test="${pagination.currentPage<pagination.totalPage}">
        <td><a href="/contact/list?term=${term}&currentPage=${currentPage+1}">下一页</a></td>
        <td><a href=/contact/list?term=${term}&currentPage=${totalPage}>尾页</a></td>
      </c:if>
      <c:if test="${pagination.totalPage>0}">
        <td>共${pagination.totalPage}页</td>
      </c:if>
    </tr>
  </table>
  <div id="list-sure" class="list-sure" style="display: none">
    <div class="list-sure-title"></div>
    <div class="list-sure-content">
      确认删除信息？
    </div>
    <div class="list-sure-btn">
      <a class="list-sure-btn1" href="javascript:void(0);">确认</a>
      <a class="list-sure-btn2" href="javascript:void(0);">取消</a>
    </div>
  </div>
</div>
</body>
<script src="/resources/customer-list/customer-list.js"/>
</html>
