<%--
  Created by IntelliJ IDEA.
  User: zhoupengxiao
  Date: 16/5/18
  Time: 上午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>操作成功</title>
    <style>
      * {
        margin: 0;
        padding: 0;
      }

      .info {
        position: fixed;
        top: 50%;
        left: 50%;
        margin: -150px 0 0 -250px;
        width: 500px;
        height: 200px;
        background: #f3f3f3;
        box-shadow: 0 3px 10px 5px #ccc;
      }

      .info-title {
        line-height: 60px;
        height: 60px;
        color: white;
        background: #45a5e3;
        font-size: 20px;
        text-indent: 20px;
      }

      .info-content {
        padding-top: 60px;
        text-align: center;
        color: #333;
        font-size: 16px;
      }

      a {
        color: #45a5f3;
        text-decoration: none;
      }

      a:hover {
        text-decoration: underline;
      }
    </style>
  </head>
  <body>
  <div class="info">
    <div class="info-title">
      操作成功!
    </div>
    <!--请在下面连接中写入跳转连接,并在js中添加地址-->
    <input type="hidden" id="contactId" value="${smsInfo.contactId}"/>
    <div class="info-content"><span id="time">5</span>秒后跳转到<a href="/order/list?contactId=${smsInfo.contactId}">客户购买</a> 页面</div>
  </div>

  <script>
    var time = document.getElementById('time');
    var contactId = document.getElementById('contactId').value;
    function timeDown() {
      if (time.innerHTML > 1) {
        time.innerHTML =  time.innerHTML - 1;
        setTimeout(timeDown, 1000);
      } else {
        //在此处填写跳转的地址
        window.location = '/order/list?contactId=' + contactId;
      }
    }
    setTimeout(timeDown, 1000);

  </script>
  </body>
</html>
