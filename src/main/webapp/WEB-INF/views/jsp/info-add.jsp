<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  <c:choose>
    <c:when test="${smsInfo.id == null}">
      <form action="/smsInfo/add" method="post"/>
    </c:when>
    <c:otherwise>
      <form action="/smsInfo/update" method="post"/>
    </c:otherwise>
  </c:choose>
    <input name="id" type="hidden" value="${smsInfo.id}"/>
    <input name="invoiceId" type="hidden" value="${smsInfo.invoiceId}"/>
    <h2>用户信息</h2>
    <table class="content-table">
      <tr>
        <th>用户ID:</th>
        <td>
          <input name="contactId" type="text" value="${smsInfo.contactId}"/>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.contactId"/></td>
      </tr>
      <tr>
        <th>用户名称:</th>
        <td>
          <input name="contactName" type="text" value="${smsInfo.contactName}"/>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.contactName"/></td>
      </tr>
      <tr>
        <th>手机号码:</th>
        <td>
          <input name="phone" class="invest-text" type="text" value="${smsInfo.phone}"/>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.phone"/></td>
      </tr>
    </table>
    <h2>产品信息</h2>
    <table class="content-table">
      <tr>
        <th>产品ID:</th>
        <td>
          <input name="goodsId" class="invest-text" type="text" value="${smsInfo.goodsId}"/>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.goodsId"/></td>
      </tr>
      <tr>
        <th>产品名称:</th>
        <td>
          <input name="goodsName" class="invest-address-text" type="text" value="${smsInfo.goodsName}"/>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.goodsName"/></td>
      </tr>
      <tr>
        <th>产品型号:</th>
        <td>
          <input name="goodsModel" class="invest-text" type="text" value="${smsInfo.goodsModel}"/>
        </td>
        <td class="wrong-text"></td>
      </tr>
      <tr>
        <th>发送短信时间:</th>
        <td>
          <input name="sendDate" value='<fmt:formatDate value="${smsInfo.sendDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' id="btn" class="calender-time" type="text" id="calendar1" maxlength="16"  onfocus="$(this).calendar()" readonly/>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.sendDate"/></td>
      </tr>
      <tr>
        <th>发送短信模板:</th>
        <td>
          <!--请在option的value里面写上模板的具体内容-->
          <select class="choose-message" id="chooseMessage" data-value="请选择">
            <option value="">请选择</option>
            <c:forEach items="${temps}" var="temp">
              <option value="${temp.content}">${temp.title}</option>
            </c:forEach>
          </select>
        </td>
        <td class="wrong-text"></td>
      </tr>
      <tr>
        <th>发送短信内容:</th>
        <td>
          <textarea id="smsContent" name="smsContent" cols="30" rows="10" placeholder="" maxlength="200">${smsInfo.smsContent}</textarea>
        </td>
        <td class="wrong-text"><form:errors path="smsInfo.smsContent"/></td>
      </tr>
      <tr>
        <th></th>
        <td>
          请注意:只有 [ ] 里面的内容可以进行修改
        </td>
        <td class="wrong-text"></td>
      </tr>
      <tr>
        <th></th>
        <td><input class="invest-submit" type="submit" value="保存"/></td>
      </tr>
    </table>
  </form>

  <script src="/resources/core/jq/Jquery-date-and-time/jquery-1.3.2.js"></script>
  <script src="/resources/core/jq/Jquery-date-and-time/jquery-calendar.js"></script>
  <script src="/resources/customer/customer.js" ></script>

  </body>
</html>
