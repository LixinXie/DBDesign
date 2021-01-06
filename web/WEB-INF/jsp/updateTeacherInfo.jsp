<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教职工信息</title>
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
            <a href="${pageContext.request.contextPath}/toManageTeacher?userId=${userId}&userType=${userType}">取消</a>
        </button>
    </h5>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <div class="page-header">
                    <h1>
                        <small>修改教职工信息</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/updateTeacherInfo?userId=${userId}&userType=${userType}" method="post">
            <div class="form-group">
                <label for="tno">教职工号: </label>
                <input type="hidden" name="tNo" class="form-control" value="${currTeacher.TNo}">
                <input type="text" name="tNo" class="form-control" id="tno" value="${currTeacher.TNo}" disabled>
            </div>
            <div class="form-group">
                <label for="tname">姓名: </label>
                <input type="text" name="tName" class="form-control" id="tname" value="${currTeacher.TName}" required>
            </div>
            <div class="form-group">
                <label for="tsex">性别: </label>
                <select id="tsex" name="tSex">
                    <option value="${currTeacher.TSex}" selected="selected">-</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label for="tbirthday">出生日期: </label>
                <input type="date" name="tBirthday" class="form-control" id="tbirthday" value="${currTeacher.TBirthday}" required>
            </div>
            <div class="form-group">
                <label for="dno">系: </label>
                <select id="dno" name="dNo">
                    <option value="${currTeacher.DNo}" selected="selected">-</option>
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
                <label for="ttitle">职称: </label>
                <input type="text" name="tTitle" class="form-control" id="ttitle" value="${currTeacher.TTitle}" required>
            </div>
            <div class="form-group">
                <label for="tmajor">专业及方向: </label>
                <input type="text" name="tMajor" class="form-control" id="tmajor" value="${currTeacher.TMajor}" required>
            </div>
            <div class="form-group">
                <label for="pswd">登录密码: </label>
                <input type="text" name="pswd" class="form-control" id="pswd" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
            <span style="color: red; font-weight: bold">${updateTeacherMsg}</span>
            <button type="button" value="修改其他教职工的信息">
                <a href="${pageContext.request.contextPath}/toInputTno?userId=${userId}&userType=${userType}">修改其他教职工的信息</a>
            </button>
        </form>
    </div>

</body>
</html>
