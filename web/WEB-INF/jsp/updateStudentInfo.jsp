<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
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
                        <small>修改学生信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/updateStudentInfo?userId=${userId}&userType=${userType}" method="post">
            <div class="form-group">
                <label for="sno">学号: </label>
                <input type="hidden" name="sNo" class="form-control"value="${currStudent.SNo}">
                <input type="text" name="sNo" class="form-control" id="sno" value="${currStudent.SNo}" disabled>
            </div>
            <div class="form-group">
                <label for="sname">姓名: </label>
                <input type="text" name="sName" class="form-control" id="sname" value="${currStudent.SName}" required>
            </div>
            <div class="form-group">
                <label for="sbirthday">出生日期: </label>
                <input type="date" name="sBirthday" class="form-control" id="sbirthday" value="${currStudent.SBirthday}" required>
            </div>
            <div class="form-group">
                <label for="ssex">性别: </label>
                <select id="ssex" name="sSex">
                    <option value="${currStudent.SSex}" selected="selected">当前性别</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label for="enrollgrade">入学成绩: </label>
                <input type="text" name="enrollGrade" class="form-control" id="enrollgrade" value="${currStudent.enrollGrade}" required>
            </div>
            <div class="form-group">
                <label for="dno">系: </label>
                <select id="dno" name="dNo">
                    <option value="${currStudent.DNo}" selected="selected">当前系</option>
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
                    <option value="${currStudent.SStatus}" selected>当前状态</option>
                    <option value="在读">在读</option>
                    <option value="毕业">毕业</option>
                </select>
            </div>
            <div class="form-group">
                <label for="pswd">登录密码: </label>
                <input type="text" name="pswd" class="form-control" id="pswd" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
            <span style="color: red; font-weight: bold">${updateStudentMsg}</span>
            <button type="button" value="修改其他学生的信息">
                <a href="${pageContext.request.contextPath}/toInputSno?userId=${userId}&userType=${userType}">修改其他学生的信息</a>
            </button>
        </form>
    </div>

</body>
</html>
