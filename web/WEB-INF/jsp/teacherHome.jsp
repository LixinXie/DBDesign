<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教职工主页</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h3>
        &nbsp;&nbsp;欢迎您: ${userId}&nbsp;老师
        <div style="text-align: right">
            <button type="button">
                <a href="${pageContext.request.contextPath}/login/toLogin">退出登录</a>
            </button>&nbsp;&nbsp;
        </div>
    </h3><br><br>
</body>
</html>
