<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系信息查询</title>
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
        <form class="form-inline" action="${pageContext.request.contextPath}/queryDepartmentInfo" method="post">
            按
            <select name="searchType">
                <option>系号</option>
                <option>系名</option>
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
                        <th>系号</th>
                        <th>系名</th>
                        <th>描述</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="department" items="${departments}">
                        <tr>
                            <td>${department.DNo}</td>
                            <td>${department.DName}</td>
                            <td>${department.DDescription}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
