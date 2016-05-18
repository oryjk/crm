<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/18
  Time: 下午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/smsInfo/saveTemp" method="post">
  <%--<input type="hidden" name="id" value="${smsTemp.id}"/>--%>
  标题:<input name="title" type="text" value="${smsTemp.title}"/><br>
  内容:<textarea name="content">${smsTemp.content}</textarea>
  <button type="submit">提交</button>
</form>
</body>
</html>
