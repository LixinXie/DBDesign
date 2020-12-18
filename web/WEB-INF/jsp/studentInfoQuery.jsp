<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息查询</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table th, .table td{
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backStuHome?userId=${userId}">回到主页</a>
        </button>
    </h5>
    <br><br>
    <div align="center">
        <form class="form-inline" action="${pageContext.request.contextPath}/queryStudentInfo" method="post">
            按
            <select name="searchType">
                <option>学号</option>
                <option>姓名</option>
                <option>系号</option>
            </select>
            查询
            &nbsp;
            <input type="text" name="searchText" placeholder="请输入查询关键字">&nbsp;
            <input class="btn-default" type="submit" value="查询">&nbsp;
            <span style="color: red; font-weight: bold">${error}</span>
        </form>
    </div>

    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12">
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
                    <c:forEach var="student" items="${result}">
                        <tr>
                            <td>${student.SNo}</td>
                            <td>${student.SName}</td>
                            <td>${student.SBirthday}</td>
                            <td>${student.SSex}</td>
                            <td>${student.enrollGrade}</td>
                            <td>${student.DNo}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
