<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>软件学院两委会综合服务平台</title>
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
                <a class="navbar-brand">注册学生账号</a>
            </div>
        </div><!-- /.container-fluid -->
        <div class="container">
            <form action="<%=basePath%>pages/back/student_insert.action" method="post" class="form-horizontal" id="insertForm">
                <div class="form-group">
                    <label for="st_number" class="control-label col-md-3">学生账号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="st_number" id="st_number" placeholder="请输入学生账号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="st_number" class="control-label col-md-3">学生账号密码</label>
                    <div class="col-md-5">
                        <input type="password" class="form-control" name="st_password" id="st_password" placeholder="请设置该账号密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="st_number" class="control-label col-md-3">学生姓名</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="st_name" id="st_name" placeholder="请输入学生姓名">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-6">
                        <button type="submit" class="btn btn-success btn-sm">增加</button>
                        <button type="submit" class="btn btn-danger btn-sm">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </nav>
</div>
<jsp:include page="/pages/admin/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/student_insert.js"></script>
</body>
</html>