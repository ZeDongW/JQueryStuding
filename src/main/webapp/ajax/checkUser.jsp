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
    <title>校验用户名</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>
    <form>
        <table align="center" border="1px">
            <tr>
                <td>用户名</td>
                <td><input id="userNameID" type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input id="passWordID" type="password" name="passWord"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="subminID" type="button" value="提交"/><span id="resultID"></span></td>
            </tr>
        </table>
    </form>
</body>
    <script type="text/javascript">
        $(" #subminID").click(function () {

            $("#resultID").text("");
            //获取用户名密码
            let userName = $.trim($("#userNameID").val());
            let passWord = $.trim($("#passWordID").val());

            //判断用户名密码不为空
            if (userName.length == 0 || passWord.length == 0){
                alert("用户名、密码不能为空");
                return false;
            }

            let url = "${pageContext.request.contextPath}/checkUser?time=" + new Date().getTime();

            let data = $(" form").serialize();

            $.post(url, data, function (result) {
                let $img = $("<img width='45px' height='20px'/>");
                $img.attr("src",result);
                $("#resultID").append($img);
            });
        });
    </script>
</html>
