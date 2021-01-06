<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改系别信息</title>
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
            <a href="${pageContext.request.contextPath}/toManageDepartment?userId=${userId}&userType=${userType}">取消</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="page-header">
                    <h1>
                        <small>修改系别信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/updateDepartmentInfo?userId=${userId}&userType=${userType}" method="post">
            <div class="form-group">
                <label for="dno">系号: </label>
                <input type="hidden" name="dNo" class="form-control" value="${currDept.DNo}">
                <input type="text" name="dNo" class="form-control" id="dno" value="${currDept.DNo}" disabled>
            </div>
            <div class="form-group">
                <label for="dname">系名: </label>
                <input type="text" name="dName" class="form-control" id="dname" value="${currDept.DName}" required>
            </div>
            <div class="form-group">
                <label for="ddescription">系描述: </label>
                <input type="text" name="dDescription" class="form-control" id="ddescription" value="${currDept.DDescription}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
            <span style="color: red; font-weight: bold">${updateDeptMsg}</span>
            <button type="button" value="修改其他系别的信息">
                <a href="${pageContext.request.contextPath}/toInputDno?userId=${userId}&userType=${userType}">修改其他系别的信息</a>
            </button>
        </form>
    </div>

</body>
</html>
