<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/17
  Time: 下午2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/customer/customer.css"/>
    <link rel="stylesheet" href="/resources/core/jq/Jquery-date-and-time/jquery-calendar.css"/>
    <script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js"></script>
    <script src="/resources/core/jq/Jquery-date-and-time/jquery-calendar.js"></script>
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

  <form action="/smsInfo/add" method="post">
    <h2>用户信息</h2>
    <table class="content-table">
      <tr>
        <th>用户ID:</th>
        <td>
          <input name="contactId" type="text" value="${smsInfo.contactId}"/>
          <form:errors path="smsInfo.contactId" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <th>用户名称:</th>
        <td>
          <input name="contactName" type="text" value="${smsInfo.contactName}"/>
          <form:errors path="smsInfo.contactName" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <th>手机号码:</th>
        <td>
          <input name="phone" class="invest-text" type="text" value="${smsInfo.phone}"/>
          <form:errors path="smsInfo.phone" cssStyle="color: red"/>
        </td>
      </tr>
    </table>
    <h2>产品信息</h2>
    <table class="content-table">
      <tr>
        <th>产品ID:</th>
        <td>
          <input name="goodsId" class="invest-text" type="text" value="${smsInfo.goodsId}"/>
          <form:errors path="smsInfo.goodsId" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <th>产品名称:</th>
        <td>
          <input name="goodsName" class="invest-address-text" type="text" value="${smsInfo.goodsName}"/>
          <form:errors path="smsInfo.goodsName" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <th>产品型号:</th>
        <td>
          <input name="goodsModel" class="invest-text" type="text" value="${smsInfo.goodsModel}"/>
        </td>
      </tr>
      <tr>
        <th>发送短信时间:</th>
        <td>
          <input name="sendDate" value="${smsInfo.sendDate}" id="btn" class="calender-time" type="text" id="calendar1" maxlength="16"  onfocus="$(this).calendar()" readonly/>
          <form:errors path="smsInfo.sendDate" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <th>发送短信内容:</th>
        <td>
          <textarea name="smsContent" cols="30" rows="10" placeholder="" maxlength="200">${smsInfo.smsContent}</textarea>
          <form:errors path="smsInfo.smsContent" cssStyle="color: red"/>
        </td>
      </tr>
      <tr>
        <th></th>
        <td><input class="invest-submit" type="submit" value="保存"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
