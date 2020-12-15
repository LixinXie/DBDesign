<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息查询</title>
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
        <form class="form-inline" action="${pageContext.request.contextPath}/queryCourseInfo" method="post">
            按
            <select name="searchType">
                <option>课程号</option>
                <option>课程名</option>
                <option>任课教师名</option>
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
                        <th>课程号</th>
                        <th>课程名</th>
                        <th>任课教师号</th>
                        <th>任课教师名</th>
                        <th>学时</th>
                        <th>学分</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>考试时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="department" items="${resultMap.keySet()}">
                        <tr>
                            <td>${department.CNo}</td>
                            <td>${department.CName}</td>
                            <td>${department.TNo}</td>
                            <td>${resultMap.get(department).TName}</td>
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
