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
</head>

<body>
    <div class="header-blue" style="height:80px;padding:0px;padding-top:0px;padding-bottom:0px;">
        <nav class="navbar navbar-default navigation-clean-search">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand" href="pages/student/student_index.jsp">软件学院两委会综合服务平台</a><button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button></div>
                <div
                        class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li role="presentation"><a href="pages/student/student_index.jsp">首页</a></li>
                        <li role="presentation"><a href="pages/student/student_article.jsp">通知公告</a></li>
                        <li role="presentation"><a href="pages/student/student_sign.jsp">活动报名</a></li>
                        <li role="presentation"><a href="pages/student/student_document.jsp">材料上报</a></li>
                        <li role="presentation"><a href="pages/student/after_class/after_class_ volunteer.jsp">第二课堂</a></li>
                    </ul>
                    <p class="navbar-text navbar-right" style="color: white"><%=request.getSession().getAttribute("st_name")%>，欢迎您！<a class="btn btn-default action-button" role="button" href="<%=basePath%>pages/back/student_logout.action">点击退出</a></p>
                </div>
            </div>
        </nav>
    </div>
</body>

</html>