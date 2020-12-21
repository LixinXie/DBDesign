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
                <a href="${pageContext.request.contextPath}/logout">退出登录</a>
            </button>&nbsp;&nbsp;
        </div>
    </h3><br><br>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12" align="center">
                <button type="button" value="信息查询">
                    <a href="${pageContext.request.contextPath}/toQueryInfoHome?userId=${userId}&userType=教职工">信息查询</a>
                </button><br><br>
                <button type="button" value="成绩管理">
                    <a href="${pageContext.request.contextPath}/toManageGrade?userId=${userId}&userType=教职工">成绩管理</a>
                </button><br><br>
            </div>
        </div>
    </div>
</body>
</html>
