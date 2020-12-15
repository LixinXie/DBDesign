<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教职工信息查询</title>
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
    <br><br>
    <div align="center">
        <form class="form-inline" action="${pageContext.request.contextPath}/queryTeacherInfo" method="post">
            按
            <select name="searchType">
                <option>职工号</option>
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
                        <th>职工号</th>
                        <th>姓名</th>
                        <th>出生日期</th>
                        <th>性别</th>
                        <th>所在系号</th>
                        <th>职称</th>
                        <th>专业及教学方向</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="department" items="${teachers}">
                        <tr>
                            <td>${department.TNo}</td>
                            <td>${department.TName}</td>
                            <td>${department.TBirthday}</td>
                            <td>${department.TSex}</td>
                            <td>${department.DNo}</td>
                            <td>${department.TTitle}</td>
                            <td>${department.TMajor}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
