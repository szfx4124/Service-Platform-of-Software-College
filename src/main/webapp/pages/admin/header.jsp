<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>管理端-软件学院两委会综合服务平台</title>
    <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="js/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="js/morrisjs/morris.css" rel="stylesheet">
    <link href="js/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>

<div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">管理端-软件学院两委会综合服务平台</a>
        </div>
        </li>
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a><i class="fa fa-user fa-fw"></i> 用户信息</a>
                    </li>
                    <li><a><i class="fa fa-gear fa-fw"></i> 设置</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="pages/admin/admin_index.jsp"><i class="fa fa-dashboard fa-fw"></i>首页</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 学生账号管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/admin/back/student/student_insert.jsp">注册学生账号</a>
                            </li>
                            <li>
                                <a href="pages/admin/back/student/student_list.jsp">学生账号列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 活动报名管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/admin/back/activity/yuandan_list.jsp">软件学院2019年元旦晚会</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-file-archive-o fa-fw"></i> 材料上报管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/admin/back/document/sanxiao_list.jsp">软件学院第十三届三小中期检查</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-hand-pointer-o fa-fw"></i> 第二课堂认定<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/admin/back/volunteer/volunteer_list.jsp">待认定志愿服务</a>
                                <a href="pages/admin/back/volunteer/volunteer_confirm_list.jsp">已认定志愿服务</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bullhorn fa-fw"></i> 通知文件管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/admin/back/notice/notice_insert.jsp">发布通知</a>
                            </li>
                            <li>
                                <a href="pages/admin/back/notice/notice_list.jsp">通知列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-comment-o fa-fw"></i> 内部公告管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/admin/back/board/board_insert.jsp">发布公告</a>
                            </li>
                            <li>
                                <a href="pages/admin/back/board/board_list.jsp">公告列表</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>