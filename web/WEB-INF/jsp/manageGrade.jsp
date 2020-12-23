<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩管理</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backHome?userId=${userId}&userType=${userType}">回到主页</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <br><br><br>
            <div align="center">
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath}/toAddGrade?userId=${userId}&userType=${userType}">录入成绩</a>
            </div><br>
            <div align="center">
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath}/toInputSnoCno?userId=${userId}&userType=${userType}">修改成绩</a>
            </div><br>
            <div align="center">
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath}/toQueryGradeInfo?userId=${userId}&userType=${userType}">查询成绩</a>
            </div>
        </div>
    </div>
</body>
</html>
