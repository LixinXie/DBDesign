<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录账号</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div align="center" style="margin: 100px auto">
        <h4>请登录</h4><br>
        <form action="${pageContext.request.contextPath}/login/toHome" method="post">
            <span style="color: red; font-weight: bold">${error}</span><br>
            账号: <input type="text" name="userid" required><br><br>
            密码: <input type="password" name="pswd" required><br><br>
            <select name="ptype">
                <option>学生</option>
                <option>教职工</option>
                <option>管理员</option>
            </select>
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
