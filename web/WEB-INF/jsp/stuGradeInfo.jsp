<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人成绩信息</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
                    <c:forEach var="course" items="${stuCourse}">
                        <tr>
                            <td>${course.CNo}</td>
                            <td>${course.CName}</td>
                            <td>${course.TNo}</td>
                            <td>${course.CHour}</td>
                            <td>${course.CCredit}</td>
                            <td>${course.CTime}</td>
                            <td>${course.CSite}</td>
                            <td>${course.CTestTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</body>
</html>
