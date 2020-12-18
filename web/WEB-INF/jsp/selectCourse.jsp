<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人选课</title>
    <%--BootStrap--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table th, .table td{
            text-align: center;
            vertical-align: middle !important;
        }
    </style>

<%--    <script type="text/javascript">--%>
<%--        // 判断是否选课成功--%>
<%--        function judgeIfCanSelectCourse(cNo) {--%>
<%--            //var ms = document.querySelector('[name = "select"]').value;--%>
<%--            var msg = document.getElementById("select" + cNo).value;--%>
<%--            //alert(cNo);--%>
<%--            if(msg == "ok"){--%>
<%--                alert("选课成功!");--%>
<%--            }else{--%>
<%--                alert(msg);--%>
<%--            }--%>
<%--        }--%>
<%--        // 判断是否退选成功--%>
<%--        function judgeIfCanDeselectCourse(cNo) {--%>
<%--            var msg = document.getElementById("deSelect" + cNo).value;--%>
<%--            if(msg == "ok"){--%>
<%--                alert("退选成功!");--%>
<%--            }else{--%>
<%--                alert(msg);--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>

</head>
<body>
    <h5>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">
            <a href="${pageContext.request.contextPath}/backStuHome?userId=${userId}">回到主页</a>
        </button>
    </h5>
    <br><br>
    <h3 align="center">已选课程</h3>
    <h5 align="right">已选课程总学分: ${gotCredits}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5>
    <h5 align="right">可选课程学分上限: 15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5>
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>课程号</th>
                        <th>课程名</th>
                        <th>任课教师号</th>
                        <th>任课教师名</th>
                        <th>学时</th>
                        <th>学分</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>考试时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${selectedCourseMap.keySet()}">
                        <tr>
                            <td>${course.CNo}</td>
                            <td>${course.CName}</td>
                            <td>${course.TNo}</td>
                            <td>${selectedCourseMap.get(course).TName}</td>
                            <td>${course.CHour}</td>
                            <td>${course.CCredit}</td>
                            <td>${course.CTime}</td>
                            <td>${course.CSite}</td>
                            <td>${course.CTestTime}</td>
                            <td>
                                    <%--     <input type="hidden" value="${deSelectMsg}" id="deSelect${course.CNo}">--%>
                                    <%-- <button type="button" onclick="judgeIfCanDeselectCourse('${course.CNo}')">--%>
                                    <%--    <a href="${pageContext.request.contextPath}/deselect?userId=${userId}&cNo=${course.CNo}">退选</a>--%>
                                    <%-- </button>--%>
                                <button type="button">
                                    <a href="${pageContext.request.contextPath}/deselect?userId=${userId}&cNo=${course.CNo}">退选</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <br><br><br>
    <h3 align="center">所有课程</h3>
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>课程号</th>
                        <th>课程名</th>
                        <th>任课教师号</th>
                        <th>任课教师名</th>
                        <th>学时</th>
                        <th>学分</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>考试时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${allCourseMap.keySet()}">
                        <tr>
                            <td>${course.CNo}</td>
                            <td>${course.CName}</td>
                            <td>${course.TNo}</td>
                            <td>${allCourseMap.get(course).TName}</td>
                            <td>${course.CHour}</td>
                            <td>${course.CCredit}</td>
                            <td>${course.CTime}</td>
                            <td>${course.CSite}</td>
                            <td>${course.CTestTime}</td>
                            <td>
                            <%--   <input type="hidden" value="${selectMsg}" id="select${course.CNo}">--%>
                            <%--    <button type="button" onclick="judgeIfCanSelectCourse('${course.CNo}')">--%>
                            <%--       <a href="${pageContext.request.contextPath}/select?userId=${userId}&cNo=${course.CNo}">选课</a>--%>
                            <%--    </button>--%>
                                <button type="button">
                                    <a href="${pageContext.request.contextPath}/select?userId=${userId}&cNo=${course.CNo}">选课</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
