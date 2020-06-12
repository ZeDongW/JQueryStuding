<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2020/6/11 0011
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过JQueryAjax获取当前时间</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>
    当前时间：<span id="nowTime"></span>
    <input type="button" value="获取当前时间" id="getNowTime">
</body>
    <script type="text/javascript">
        $("#getNowTime").click(function () {
            $("#nowTime").load("${pageContext.request.contextPath}/getNowTime?time=" + new Date().getTime());
        });
    </script>
</html>
