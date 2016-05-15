<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/15
  Time: 上午10:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
    <title></title>
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

<div class="content">
    <div class="content-searchBox">
        <form action="/smsInfo/">
            <input class="content-search" name="term" value="${term}" type="search" placeholder="请输入搜索信息">
            <button class="content-search-btn" type="submit"></button>
        </form>
    </div>
    <table class="content-list">
        <tr class="list-title">
            <td>用户姓名</td>
            <td>手机号码</td>
            <td>产品名称</td>
            <td>购买日期</td>
            <td>短信发送日期</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${infoList}" var="info">
            <tr class="list-top">
                <td>${info.contactName}</td>
                <td>${info.phone}</td>
                <td>${info.goodsName}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${info.updateDate}"/></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${info.updateDate}"/></td>
                <td>
                    <a class="list-delete" href="#">查看详情</a>
                    <a class="list-delete" href="#">购买信息</a>
                    <a class="list-delete" href="javascript:viod(0)">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table class="list-page">
        <tr>
            <td><a href="#">首页</a></td>
            <td><a href="#">上一页</a></td>

            <%
                for (int i = 1; i < Integer.parseInt(request.getParameter("pageCount")); i++) {

            %>
                    <td><a href="/smsInfo/search?term=${param.term}&currentPage=<%=i%>"><%=i%></a></td>
            <%
                }
            %>
            <c:if test=""></c:if>
            <td><a href="/smsInfo/search?term=${param.term}&currentPage=<%=i+1%>">下一页</a></td>
            <td><a href="#">尾页</a></td>
            <td>共${pageContext}页</td>

        </tr>
    </table>
    <div id="list-sure" class="list-sure" style="display: none">
        <div class="list-sure-title"></div>
        <div class="list-sure-content">
            确认删除信息？
        </div>
        <div class="list-sure-btn">
            <a class="list-sure-btn1" href="#">确认</a>
            <a class="list-sure-btn2" href="javascript:viod(0)">取消</a>
        </div>
    </div>
</div>
</body>
<script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js"></script>
<script src="/resources/customer-list/customer-list.js"></script>
</html>
