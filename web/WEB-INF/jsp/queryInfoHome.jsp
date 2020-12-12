<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息查询</title>
</head>
<body>
    <br><br>
    <h3 align="center">请选择查询项</h3>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12" align="center">
                <button value="查询学生">
                    <a href="${pageContext.request.contextPath}/toQueryStudentInfo">查询学生</a>
                </button><br><br>
                <button value="查询课程">
                    <a href="${pageContext.request.contextPath}/toQueryCourseInfo">查询课程</a>
                </button><br><br>
                <button value="查询教师">
                    <a href="${pageContext.request.contextPath}/toQueryTeacherInfo">查询教师</a>
                </button><br><br>
                <button value="查询系别">
                    <a href="${pageContext.request.contextPath}/toQueryDepartmentInfo">查询系别</a>
                </button><br><br>
            </div>
        </div>
    </div>

</body>
</html>
