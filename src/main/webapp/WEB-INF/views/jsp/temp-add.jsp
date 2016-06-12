<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/18
  Time: 下午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/resources/message-template/template-add-and-modify.css"/>
</head>
<body>
<!-- header-begin -->
<div class="header">
  <div class="header-content">
    <h1>客户管理</h1>
    <div class="header-name">
      <img src="/resources/core/image/touxiang.png" alt=""/>
      <span>zhouzhou</span>
    </div>
  </div>
</div>
<!-- header-end -->
<form action="/smsInfo/saveTemp" method="post">
  <c:choose>
    <c:when test="${smsTemp.id==null}">
      <h2>新增模板</h2>
    </c:when>
    <c:otherwise>
      <h2>修改模板</h2>
    </c:otherwise>
  </c:choose>
  <table class="content-table">
    <c:if test="${smsTemp.id!=null}">
      <tr>
        <th>模板id:</th>
        <td>${smsTemp.id}</td>
      </tr>
    </c:if>
    <tr>
      <th>模板标题:</th>
      <input name="id" type="hidden" value="${smsTemp.id}"/>
      <td><input name="title" type="text" value="${smsTemp.title}"/></td>
      <td class="wrong-text"><form:errors path="title.required"/></td>
    </tr>
    <tr>
      <th>模板内容:</th>
      <td><textarea name="content" cols="30" rows="10"  maxlength="200">${smsTemp.content}</textarea>
      </td>
      <td class="wrong-text"><form:errors path="content.required"/></td>
    </tr>
    <tr>
      <th></th>
      <td>
        <input class="invest-submit" type="submit" value="保存"/>
        <a class="back" href="#">返回</a>
      </td>
    </tr>
  </table>
</form>
</body>
<script src="/resources/message-template/message-template.js"/>
</html>
