<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入成绩</title>
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
            <a href="${pageContext.request.contextPath}/toManageGrade?userId=${userId}&userType=${userType}">取消</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="page-header">
                    <h1>
                        <small>录入成绩</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/addGrade?userId=${userId}&userType=${userType}" method="post">
            <div class="form-group">
                <label for="sno">学号: </label>
                <input type="text" name="sNo" class="form-control" id="sno" required>
            </div>
            <div class="form-group">
                <label for="cno">课程号: </label>
                <input type="text" name="cNo" class="form-control" id="cno" required>
            </div>
            <div class="form-group">
                <label for="usualGrade">平时成绩: </label>
                <input type="text" name="usualGrade" class="form-control" id="usualGrade" required>
            </div>
            <div class="form-group">
                <label for="testGrade">考试成绩: </label>
                <input type="text" name="testGrade" class="form-control" id="testGrade" required>
            </div>
            <div class="form-group">
                <label for="generalGrade">总评成绩: </label>
                <input type="text" name="generalGrade" class="form-control" id="generalGrade" required>
            </div>
            <div class="form-group">
                <span style="color: red; font-weight: bold">${addGradeMsg}</span>
                <input type="submit" class="form-control" value="录入">
            </div>

        </form>
    </div>
</body>
</html>
