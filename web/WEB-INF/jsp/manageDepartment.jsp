<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理系别</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backHome?userId=${userId}&userType=${userType}">回到主页</a>
        </button>&nbsp;&nbsp;
    </h5>
    <div class="span12" align="center">
<%--        <button type="button" value="录入系别信息">--%>
<%--            <a href="${pageContext.request.contextPath}/toAddDepartmentInfo?userId=${userId}&userType=管理员">录入系别信息</a>--%>
<%--        </button><br><br>--%>
        <button type="button" value="修改系别信息">
            <a href="${pageContext.request.contextPath}/toInputDno?userId=${userId}&userType=管理员">修改系别信息</a>
        </button><br><br>
    </div>
</body>
</html>
