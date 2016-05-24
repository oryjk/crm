<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/18
  Time: 下午12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="/resources/message-template/message-template.css"/>
  <title></title>
</head>
<body>
<!-- header-begin -->
<jsp:include page="header.jsp">
  <jsp:param name="title" value="短信模板管理"/>
</jsp:include>
<!-- header-end -->

<div class="content">
  <table class="content-list">
    <tr class="list-title">
      <td>模板名字</td>
      <td style="width: 600px;">模板内容</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${smsTemps}" var="smsTemp" varStatus="index">
      <c:choose>
        <c:when test="${index.count%2!=0}">
          <tr class="list-top">
        </c:when>
        <c:otherwise>
          <tr class="list-bottom">
        </c:otherwise>
      </c:choose>
      <td>${smsTemp.title}</td>
      <td class="list-template-content">${smsTemp.content}</td>
      <td>
        <a class="list-modify" href="/smsInfo/addOrUpdateTemp?id=${smsTemp.id}">修改</a>
        <!--supersoup: data-value为id号-->
        <a class="list-delete" href="#" data-value="${smsTemp.id}">删除</a>
      </td>
    </tr>
    </c:forEach>
  </table>
  <table class="list-page">
    <tr>
      <c:if test="${currentPage>1}">
        <td><a href="/smsInfo//listTemp?currentPage=1">首页</a></td>
        <td><a href="/smsInfo//listTemp?currentPage=${currentPage-1}">上一页</a></td>
      </c:if>

      <c:if test="${totalPage>1}">
        <c:forEach begin="1" end="${totalPage}" var="i">
          <td><a <c:if test="${i==currentPage}">class="current-page"</c:if> href="/smsInfo//listTemp?currentPage=${i}">${i}</a></td>
        </c:forEach>
      </c:if>
      <c:if test="${currentPage<totalPage}">
        <td><a href="/smsInfo//listTemp?currentPage=${currentPage+1}">下一页</a></td>
        <td><a href="/smsInfo//listTemp?currentPage=${totalPage}">尾页</a></td>
      </c:if>
      <c:if test="${totalPage>1}">
        <td>共${totalPage}页</td>
      </c:if>
    </tr>
  </table>
  <div id="listSure" class="list-sure" style="display: none">
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
<script src="/resources/core/jq/jquery-1.11.1.js"></script>
<script src="/resources/message-template/message-template.js"></script>
</body>
</html>