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
                <a class="navbar-brand">发布通知</a>
            </div>
        </div><!-- /.container-fluid -->
        <div class="container">
            <form action="<%=basePath%>pages/back/notice_insert.action" method="post" class="form-horizontal" enctype="multipart/form-data" id="insertArticle">
                <div class="form-group">
                    <label for="title" class="control-label col-md-3">标题</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="title" id="title" placeholder="请输入标题">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="control-label col-md-3">发布人</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="name" id="name" placeholder="请输入发布人">
                    </div>
                </div>
                <div class="form-group">
                    <label for="title" class="control-label col-md-3">附件上传</label>
                    <div class="col-md-5">
                        <input type="file" name="appendix">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-6">
                        <button type="submit" class="btn btn-success btn-sm">发布</button>
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
</body>
</html>