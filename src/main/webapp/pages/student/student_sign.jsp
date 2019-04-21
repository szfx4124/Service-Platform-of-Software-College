<%--
  Created by IntelliJ IDEA.
  User: ZJH
  Date: 2018/12/1
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>软件学院两委会综合服务平台</title>
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="js/bootstrap/css/styles.min.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_752418_0cp1lx8o1dan.css">
</head>

<body>
<jsp:include page="/pages/student/student_header.jsp"/>
    <div class="contact-clean">
        <form method="post">
            <h2 class="text-center">活动报名系统</h2>
            <div class="form-group has-success" id="mytab">
                <select class="form-control" onchange="s_click(this)">
                    <option selected>点击选择所需要参与的活动</option>
                    <option value="pages/student/activity/student_sign_yuandan.jsp">软件学院2019年元旦晚会</option>
                </select>
            </div>
        </form>
    </div>
<jsp:include page="/pages/student/student_footer.jsp"/>
</body>

</html>

