<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生个人信息</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backStuHome?userId=${student.SNo}">回到主页</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h2>
                        <small>个人信息</small>
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
                        <th>姓名</th>
                        <th>出生日期</th>
                        <th>性别</th>
                        <th>入学成绩</th>
                        <th>系号</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${student.SNo}</td>
                            <td>${student.SName}</td>
                            <td>${student.SBirthday}</td>
                            <td>${student.SSex}</td>
                            <td>${student.enrollGrade}</td>
                            <td>${student.DNo}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h2>
                        <small>所在系详情</small>
                    </h2>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>系号</th>
                        <th>系名</th>
                        <th>系的描述</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${department.DNo}</td>
                        <td>${department.DName}</td>
                        <td>${department.DDescription}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
