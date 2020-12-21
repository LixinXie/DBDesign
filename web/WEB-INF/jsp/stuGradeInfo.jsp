<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人成绩信息</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backHome?userId=${userId}&userType=学生">回到主页</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h2>
                        <small>个人成绩信息</small>
                    </h2>
                </div>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>课程号</th>
                        <th>平时成绩</th>
                        <th>考试成绩</th>
                        <th>总评成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="grade" items="${stuGrades}">
                        <tr>
                            <td>${grade.SNo}</td>
                            <td>${grade.CNo}</td>
                            <td>${grade.usualGrade}</td>
                            <td>${grade.testGrade}</td>
                            <td>${grade.generalGrade}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h2>
                        <small>所选课程信息</small>
                    </h2>
                </div>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>课程号</th>
                        <th>课程名</th>
                        <th>任课教师号</th>
                        <th>学时</th>
                        <th>学分</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>考试时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="department" items="${stuCourse}">
                        <tr>
                            <td>${department.CNo}</td>
                            <td>${department.CName}</td>
                            <td>${department.TNo}</td>
                            <td>${department.CHour}</td>
                            <td>${department.CCredit}</td>
                            <td>${department.CTime}</td>
                            <td>${department.CSite}</td>
                            <td>${department.CTestTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</body>
</html>
