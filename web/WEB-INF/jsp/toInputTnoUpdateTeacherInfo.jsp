<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请输入教职工号</title>
</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backHome?userId=${userId}&userType=${userType}">回到主页</a>
        </button>&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/toManageTeacher?userId=${userId}&userType=${userType}">取消</a>
        </button>
    </h5>
    <div align="center" style="margin: 100px auto">
        <h4>请输入教职工号以修改教职工信息</h4><br>
        <form action="${pageContext.request.contextPath}/toUpdateTeacherInfo?userId=${userId}&userType=${userType}" method="post">
            <span style="color: red; font-weight: bold">${msg}</span><br>
            教职工号:&nbsp;<input type="text" name="tNo" required><br><br>
            <input type="submit" value="确定">
        </form>
    </div>
</body>
</html>
