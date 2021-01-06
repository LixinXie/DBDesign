<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请输入系号</title>
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
    <div align="center" style="margin: 100px auto">
        <h4>请输入系号以修改系别信息</h4><br>
        <form action="${pageContext.request.contextPath}/toUpdateDepartment?userId=${userId}&userType=${userType}" method="post">
            <span style="color: red; font-weight: bold">${msg}</span><br>
            系号:&nbsp;<input type="text" name="dNo" required><br><br>
            <input type="submit" value="确定">
        </form>
    </div>

</body>
</html>
