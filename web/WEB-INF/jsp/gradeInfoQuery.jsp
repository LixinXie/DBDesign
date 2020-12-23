<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩查询</title>
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
            <a href="${pageContext.request.contextPath}/backHome?userId=${userId}&userType=${userType}">回到主页</a>
        </button>&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/toManageGrade?userId=${userId}&userType=${userType}">返回上一级菜单</a>
        </button>
    </h5>
    <br><br>
    <div align="center">
        <form class="form-inline" action="${pageContext.request.contextPath}/queryGradeInfo" method="post">
            <input type="hidden" name="userId" value="${userId}">
            <input type="hidden" name="userType" value="${userType}">
            按
            <select name="searchType">
                <option>学号</option>
                <option>学生姓名</option>
                <option>课程号</option>
                <option>课程名称</option>
                <option>任课教师名</option>
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
                        <th>系号</th>
                        <th>课程号</th>
                        <th>课程名</th>
                        <th>任课教师名</th>
                        <th>学时</th>
                        <th>学分</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>考试时间</th>
                        <th>平时成绩</th>
                        <th>考试成绩</th>
                        <th>总评成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="grade" items="${GradeResult}">
                        <tr>
                            <td>${grade.SNo}</td>
                            <td>${grade.SName}</td>
                            <td>${grade.DNo}</td>
                            <td>${grade.CNo}</td>
                            <td>${grade.CName}</td>
                            <td>${grade.TName}</td>
                            <td>${grade.CHour}</td>
                            <td>${grade.CCredit}</td>
                            <td>${grade.CTime}</td>
                            <td>${grade.CSite}</td>
                            <td>${grade.CTestTime}</td>
                            <td>${grade.usualGrade}</td>
                            <td>${grade.testGrade}</td>
                            <td>${grade.generalGrade}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
