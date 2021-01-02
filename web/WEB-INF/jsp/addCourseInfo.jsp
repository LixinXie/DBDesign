<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入课程信息</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backHome?userId=${userId}&userType=${userType}">回到主页</a>
        </button>&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/toManageCourse?userId=${userId}&userType=${userType}">取消</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="page-header">
                    <h1>
                        <small>录入课程信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/addCourseInfo?userId=${userId}&userType=${userType}" method="post">
            <div class="form-group">
                <label for="cno">课程号: </label>
                <input type="text" name="cNo" class="form-control" id="cno" required>
            </div>
            <div class="form-group">
                <label for="cname">课程名: </label>
                <input type="text" name="cName" class="form-control" id="cname" required>
            </div>
            <div class="form-group">
                <label for="tno">任课教师号: </label>
                <input type="text" name="tNo" class="form-control" id="tno" required>
            </div>
            <div class="form-group">
                <label for="chour">学时: </label>
                <input type="text" name="cHour" class="form-control" id="chour" required>
            </div>
            <div class="form-group">
                <label for="ccredit">学分: </label>
                <input type="text" name="cCredit" class="form-control" id="ccredit" required>
            </div>
            <div class="form-group">
                <label for="ctime">上课时间: </label>
                <input type="text" name="cTime" class="form-control" id="ctime" required>
            </div>
            <div class="form-group">
                <label for="csite">上课地点: </label>
                <input type="text" name="cSite" class="form-control" id="csite" required>
            </div>
            <div class="form-group">
                <label for="ctesttime">考试时间: </label>
                <input type="datetime-local" name="cTestTime" class="form-control" id="ctesttime" required>
            </div>
            <div class="form-group">
                <span style="color: red; font-weight: bold">${addCourseMsg}</span>
                <input type="submit" class="form-control" value="录入">
            </div>
        </form>
    </div>

</body>