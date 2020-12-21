<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成绩</title>
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
    <div align="center" style="margin: 100px auto">
        <h4>请输入学号和课程号</h4><br>
        <form action="${pageContext.request.contextPath}/toUpdateGrade?userId=${userId}&userType=${userType}" method="post">
            <span style="color: red; font-weight: bold">${msg}</span>
            学号:&nbsp;&nbsp; <input type="text" name="sNo" required><br><br>
            课程号: <input type="text" name="cNo" required><br><br>
            <input type="submit" value="确定">
        </form>
    </div>
</body>
</html>
