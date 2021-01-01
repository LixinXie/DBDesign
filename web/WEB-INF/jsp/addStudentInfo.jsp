<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入学生信息</title>
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
            <a href="${pageContext.request.contextPath}/toManageStudent?userId=${userId}&userType=${userType}">取消</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="page-header">
                    <h1>
                        <small>录入学生信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/addStudentInfo?userId=${userId}&userType=${userType}" method="post">
            <div class="form-group">
                <label for="sno">学号: </label>
                <input type="text" name="sNo" class="form-control" id="sno" required>
            </div>
            <div class="form-group">
                <label for="sname">姓名: </label>
                <input type="text" name="sName" class="form-control" id="sname" required>
            </div>
            <div class="form-group">
                <label for="sbirthday">出生日期: </label>
                <input type="date" name="sBirthday" class="form-control" id="sbirthday" required>
            </div>
            <div class="form-group">
                <label for="ssex">性别: </label>
                <select id="ssex" name="sSex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label for="enrollgrade">入学成绩: </label>
                <input type="text" name="enrollGrade" class="form-control" id="enrollgrade" required>
            </div>
            <div class="form-group">
                <label for="dno">系: </label>
                <select id="dno" name="dNo">
                    <option value="0001">计算机学院</option>
                    <option value="0002">应用数学学院</option>
                    <option value="0003">机电工程学院</option>
                    <option value="0004">外国语学院</option>
                    <option value="0005">自动化学院</option>
                    <option value="0006">土木与交通工程学院</option>
                    <option value="0007">艺术设计学院</option>
                </select>
            </div>
            <div class="form-group">
                <label for="sstatus">状态: </label>
                <select id="sstatus" name="sStatus">
                    <option value="在读">在读</option>
                    <option value="毕业">毕业</option>
                </select>
            </div>
            <div class="form-group">
                <label for="pswd">登录密码: </label>
                <input type="text" name="pswd" class="form-control" id="pswd" required>
            </div>
            <div class="form-group">
                <span style="color: red; font-weight: bold">${addStudentMsg}</span>
                <input type="submit" class="form-control" value="录入">
            </div>

        </form>
    </div>

</body>
</html>
