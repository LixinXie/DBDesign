<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生主页</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/3.5.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h3>
        &nbsp;&nbsp;欢迎您: ${userId}<br><br>
    </h3>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12" align="center">
                <button type="button" value="个人信息">
                    <a href="${pageContext.request.contextPath}/showStuInfo?userId=${userId}">个人信息</a>
                </button><br><br>
                <button type="button" value="成绩信息">
                    <a href="${pageContext.request.contextPath}/showStuGrade?userId=${userId}">成绩信息</a>
                </button><br><br>
                <button type="button" value="选课">
                    <a href="${pageContext.request.contextPath}/toChooseCourse?userId=${userId}">选课</a>
                </button>
            </div>
        </div>
    </div>

</body>
</html>
