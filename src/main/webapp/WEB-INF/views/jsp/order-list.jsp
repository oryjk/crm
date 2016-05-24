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
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/resources/customer-purchase/customer-purchase.css"/>
    <link rel="stylesheet" href="/resources/customer-list/customer-list.css"/>
    <script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js"></script>
    <script>
      $(document).ready(function(){
        var asc = $("#asc").attr('value');
        switch (asc){
          case 'true':
            $("#pup").addClass("sort-choose");
            break;
          case 'false':
            $("#pdown").addClass("sort-choose");
            break;
          default:
            $("#pdown").addClass("sort-choose");
        }
      });
    </script>
</head>
<body>
<input type="hidden" id="asc" value="${asc}"/>
<jsp:include page="header.jsp">
  <jsp:param name="title" value="客户购买列表"/>
</jsp:include>
<!-- header-end -->
<div class="content-name">

  <div class="content-name-in">客户姓名：<span>${contact.name}</span></div>
  <div class="content-name-phone">联系方式：<span>${contact.mobile}</span></div>
</div>
<c:if test="${flag!='single'}">
  <div class="content-searchBox">
    <form action="/order/list" method="get">
      <input type="hidden" name="contactId" value="${contact.id}"/>
      <input class="content-search" name="term" value="${term}" type="search" placeholder="请输入搜索信息">
      <button class="content-search-btn" type="submit"></button>
    </form>
  </div>
</c:if>
<table class="content-list">
  <tbody>
    <tr class="list-title">
      <td style="width: 250px;" class="list-first">商品名称</td>
      <td style="width: 100px;">商品规格</td>
      <td>单价</td>
      <td>数量</td>
      <td>折扣额</td>
      <td>总金额</td>
      <td>销售人员</td>
      <td class="list-time">交易日期
        <a id="pup" class="sort-up" href="/order/list?contactId=${contact.id}&term=${term}&currentPage=1&sortFieldName=billDate&asc=true"></a>
        <a id="pdown" class="sort-down" href="/order/list?contactId=${contact.id}&term=${term}&currentPage=1&sortFieldName=billDate&asc=false"></a>
      </td>
      <td>短信操作</td>
    </tr>
    <c:forEach var="order" items="${orderList}" varStatus="index">
      <c:choose>
        <c:when test="${index.count%2!=0}">
          <tr class="list-top">
        </c:when>
        <c:otherwise>
          <tr class="list-bottom">
        </c:otherwise>
      </c:choose>
        <td>
          <span>${order.goodsName}</span>
        </td>
        <td>${order.spec}</td>
        <td class="list-red"><span>¥ ${order.price}</span></td>
        <td>${order.quantity}</td>
        <td>¥ ${order.deduction}</td>
        <td>¥ ${order.totalAmount}</td>
        <td>${order.salesMan}</td>
        <td class="list-time"><fmt:formatDate value="${order.billDate}" pattern="yyyy-MM-dd"/></td>
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
<div class="pager-box">
  <table class="list-page">
    <tr>
      <c:if test="${pagination.currentPage>1}">
        <td><a href="/order/list?contactId=${contact.id}&term=${term}&currentPage=1&sortFieldName=${pagination.sortFiledName}&asc=${asc}">首页</a></td>
        <td><a href="/order/list?contactId=${contact.id}&term=${term}&currentPage=${pagination.currentPage-1}&sortFieldName=${pagination.sortFiledName}&asc=${asc}">上一页</a></td>
      </c:if>

      <c:if test="${pagination.totalPage>1}">
        <c:forEach begin="1" end="${pagination.totalPage}" var="i">
          <td><a href="/order/list?contactId=${contact.id}&currentPage=${i}&term=${term}&sortFieldName=${pagination.sortFiledName}&asc=${asc}" <c:if test="${i==pagination.currentPage}">class="current-page"</c:if>>${i}</a></td>
        </c:forEach>
      </c:if>
      <c:if test="${pagination.currentPage<pagination.totalPage}">
        <td><a href="/order/list?contactId=${contact.id}&currentPage=${pagination.currentPage+1}&term=${term}&sortFieldName=${pagination.sortFiledName}&asc=${asc}">下一页</a></td>
        <td><a href=/order/list?contactId=${contact.id}&currentPage=${pagination.totalPage}&term=${term}&sortFieldName=${pagination.sortFiledName}&asc=${asc}>尾页</a></td>
      </c:if>
      <c:if test="${pagination.totalPage>1}">
        <td>共${pagination.totalPage}页</td>
      </c:if>
    </tr>
  </table>
</div>
</body>
</html>
