<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2020/6/11 0011
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取当前时间</title>
</head>
<body>
    当前时间：<span id="nowTime"></span>
    <input type="button" value="获取当前时间" id="getNowTime">
</body>
    <script type="text/javascript">
        document.getElementById("getNowTime").onclick = function () {
            let ajax = null;
            try{
                ajax = new XMLHttpRequest();
            } catch (e) {
                ajax = new ActiveXObject("Microsoft.XMLHTTP");
            }
            let method = "Post";
            let url = "${pageContext.request.contextPath}/getNowTime?time=" + new Date().getTime();
            ajax.open(method, url);
            ajax.send();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4){
                    if (ajax.status == 200){
                        const nowTime = ajax.responseText;
                        let spanElement = document.getElementById("nowTime");
                        spanElement.innerHTML = nowTime;
                    }
                }
            }
        }
    </script>
</html>
