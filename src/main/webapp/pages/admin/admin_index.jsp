<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>管理端-软件学院两委会综合服务平台</title>
</head>
<body>
<jsp:include page="/pages/admin/header.jsp"/>
<!--主体内容编写-->
<div id="page-wrapper">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">欢迎界面</a>
            </div>
        </div><!-- /.container-fluid -->
        <div class="jumbotron">
            <h1>Hello, <%=request.getSession().getAttribute("ad_name")%>!</h1>
            <p>今天是<%=new SimpleDateFormat("yyyy-MM-dd E a").format(new Date())%></p>
            <p>上次登录日期<%=request.getSession().getAttribute("ad_lastdate")%></p>
            <%--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>--%>
        </div>
        <div class="col-md-12">
            <table class="table table-bordered table-hover" id="boardTable">
                <tr>
                    <th>标题</th>
                    <th>发布人</th>
                    <th>内容</th>
                    <th>发布时间</th>
                </tr>
            </table>
        </div>
    </nav>
    <%--<h1>当前管理员：<%=request.getSession().getAttribute("ad_name")%></h1>--%>
    <%--<h1>上次登录日期<%=request.getSession().getAttribute("ad_lastdate")%></h1>--%>
</div>
<jsp:include page="/pages/admin/footer.jsp"/>
<script src="jquery/activity/board_list.js"></script>
</body>
</html>