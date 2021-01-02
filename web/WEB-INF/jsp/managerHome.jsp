<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h3>
        &nbsp;&nbsp;欢迎您: ${userId}&nbsp;管理员
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
                    <a href="${pageContext.request.contextPath}/toQueryInfoHome?userId=${userId}&userType=管理员">信息查询</a>
                </button><br><br>
                <button type="button" value="管理学生">
                    <a href="${pageContext.request.contextPath}/toManageStudent?userId=${userId}&userType=管理员">管理学生</a>
                </button><br><br>
                <button type="button" value="管理课程">
                    <a href="${pageContext.request.contextPath}/toManageCourse?userId=${userId}&userType=管理员">管理课程</a>
                </button><br><br>
                <button type="button" value="管理教师">
                    <a href="${pageContext.request.contextPath}/toManageTeacher?userId=${userId}&userType=管理员">管理教师</a>
                </button><br><br>
                <button type="button" value="管理系别">
                    <a href="${pageContext.request.contextPath}/toManageDepartment?userId=${userId}&userType=管理员">管理系别</a>
                </button><br><br>
            </div>
        </div>
    </div>

</body>
</html>
