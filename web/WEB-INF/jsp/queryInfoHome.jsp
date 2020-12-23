<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息查询</title>
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
    <br><br>
    <h3 align="center">请选择查询项</h3>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12" align="center">
                <button value="查询学生">
                    <a href="${pageContext.request.contextPath}/toQueryStudentInfo?userId=${userId}&userType=${userType}">查询学生</a>
                </button><br><br>
                <button value="查询课程">
                    <a href="${pageContext.request.contextPath}/toQueryCourseInfo?userId=${userId}&userType=${userType}">查询课程</a>
                </button><br><br>
                <button value="查询教师">
                    <a href="${pageContext.request.contextPath}/toQueryTeacherInfo?userId=${userId}&userType=${userType}">查询教师</a>
                </button><br><br>
                <button value="查询系别">
                    <a href="${pageContext.request.contextPath}/toQueryDepartmentInfo?userId=${userId}&userType=${userType}">查询系别</a>
                </button><br><br>
            </div>
        </div>
    </div>

</body>
</html>
