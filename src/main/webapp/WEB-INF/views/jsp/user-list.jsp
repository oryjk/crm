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
      <a class="home-btn" href="#">首页</a>
    </div>
    <div class="content-searchBox">
      <input class="content-search" type="search" placeholder="请输入搜索信息">
      <button class="content-search-btn"></button>
    </div>
  </div>
  <table class="content-list">
    <tr class="list-title">
      <td>客户名称</td>
      <td>客户编号</td>
      <td>手机</td>
      <td>座机</td>
      <td>查看购买记录</td>
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
    </tr>
    </c:forEach>
  </table>
  <table class="list-page">
    <tr>
      <td><a href="#">首页</a></td>
      <td><a href="#">上一页</a></td>
      <td><a class="current-page" href="#">1</a></td>
      <td><a href="#">2</a></td>
      <td><a href="#">3</a></td>
      <td><a href="#">4</a></td>
      <td><a href="#">5</a></td>
      <td><a href="#">6</a></td>
      <td><a href="#">7</a></td>
      <td><a href="#">下一页</a></td>
      <td><a href="#">尾页</a></td>
      <td>共10页</td>

    </tr>
  </table>
  <div id="list-sure" class="list-sure" style="display: none">
    <div class="list-sure-title"></div>
    <div class="list-sure-content">
      确认删除信息？
    </div>
    <div class="list-sure-btn">
      <a class="list-sure-btn1" href="#">确认</a>
      <a class="list-sure-btn2" href="javascript:void(0);">取消</a>
    </div>
  </div>
</div>
</body>
</html>
