<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2020/5/5 0005
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份城市区域下拉框三级联动</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>
    <form>
        <select name="bean.province" id="provinceID" >
            <option>请选择省份</option>
            <option>湖北</option>
            <option>广东</option>
            <option>云南</option>
        </select>
        <select name="bean.city" id="city" >
            <option>请选择城市</option>
        </select>
        <select name="area" id="area" >
            <option>请选择区域</option>
        </select>
    </form>
    <script type="text/javascript">

        $("#provinceID").change(function () {
            $("#city option:gt(0)").remove();
            $("#area option:gt(0)").remove();
            let province = $(this).val();
            if ("请选择省份" != province){
                let url = "${pageContext.request.contextPath}/xml_province?time=" + new Date().getTime();
                let sendData = $(" form").serialize();
                $.post(url, sendData, function (resvData) {
                    $(resvData).find("city").each(function () {
                        let $city = $("<option></option>");
                        $city.text($(this).text());
                        $("#city").append($city);
                    });
                });
            }
        });

        $("#city").change(function () {
            $("#area option:gt(0)").remove();
            let city = $(this).val();
            if ("请选择城市" != city){
                let url = "${pageContext.request.contextPath}/xml_city?time=" + new Date().getTime();
                let sendData = $(" form").serialize();
                $.post(url, sendData, function (resvData) {
                    /*console.log(resvData);
                    $(resvData.areaList).each(function () {
                        let $area = $("<option></option>");
                        $area.text(this);
                        $("#area").append($area);
                    })*/
                    $(resvData).find("area").each(function () {
                        let $area = $("<option></option>");
                        $area.text($(this).text());
                        $("#area").append($area);
                    });
                });
            }
        });
    </script>
</body>
</html>
