<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成绩</title>
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
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>修改成绩</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/updateGrade" method="post">
            <input type="hidden" name="userId" value="${userId}">
            <input type="hidden" name="userType" value="${userType}">
            <input type="hidden" name="sNo" value="${currGrade.SNo}">
            <input type="hidden" name="cNo" value="${currGrade.CNo}">
            <div class="form-group">
                <label for="sno">学号: </label>
                <input type="text" name="sNo" class="form-control" id="sno" value="${currGrade.SNo}" disabled>
            </div>
            <div class="form-group">
                <label for="cno">课程号: </label>
                <input type="text" name="cNo" class="form-control" id="cno" value="${currGrade.CNo}" disabled>
            </div>
            <div class="form-group">
                <label for="usualGrade">平时成绩: </label>
                <input type="text" name="usualGrade" class="form-control" id="usualGrade" value="${currGrade.usualGrade}" required>
            </div>
            <div class="form-group">
                <label for="testGrade">考试成绩: </label>
                <input type="text" name="testGrade" class="form-control" id="testGrade" value="${currGrade.testGrade}" required>
            </div>
            <div class="form-group">
                <label for="generalGrade">总评成绩: </label>
                <input type="text" name="generalGrade" class="form-control" id="generalGrade" value="${currGrade.generalGrade}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="录入">
            </div>
            <span style="color: red; font-weight: bold">${msg}</span>
            <button type="button" value="修改其他成绩">
                <a href="${pageContext.request.contextPath}/toInputSnoCno?userId=${userId}&userType=${userType}">修改其他成绩</a>
            </button>
        </form>
    </div>
</body>
</html>
