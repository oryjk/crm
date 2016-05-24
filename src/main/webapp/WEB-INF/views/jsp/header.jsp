<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/23
  Time: 下午11:00
  To change this template use File | Settings | File Templates.
--%>

<!-- header-begin -->
<div class="header">
  <div class="header-content">
    <h1><%=request.getParameter("title")%></h1>

    <div class="header-handle">
      <a class="header-handle-item" href="/contact/list">短信模版列表</a>
      <a class="header-handle-item" href="/contact/list">短信列表</a>
      <a class="header-handle-item" href="/contact/list">首页</a>
      <a href="javascript:window.opener = null; window.open('', '_self'); window.close();">关闭</a>
    </div>
  </div>
</div>
<!-- header-end -->