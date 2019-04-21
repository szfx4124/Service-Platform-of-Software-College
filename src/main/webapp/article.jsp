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
<div>
    <div class="header-blue" style="height:80px;padding:0px;padding-top:0px;padding-bottom:0px;">
        <nav class="navbar navbar-default navigation-clean-search">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand" href="pages/student/student_index.jsp">软件学院两委会综合服务平台</a><button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button></div>
                <div
                        class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li role="presentation"><a href="index.jsp">首页</a></li>
                        <li class="active" role="presentation"><a href="article.jsp">通知公告</a></li>
                        <li role="presentation"><a href="login.jsp" onclick="myfunction()">活动报名</a></li>
                        <li role="presentation"><a href="login.jsp" onclick="myfunction()">材料上报</a></li>
                        <li role="presentation"><a href="login.jsp" onclick="myfunction()">第二课堂</a></li>
                    </ul>
                    <p class="navbar-text navbar-right"><a class="btn btn-default action-button" role="button" href="login.jsp">点击登录</a></p>
                </div>
            </div>
        </nav>
    </div>
    <div class="contact-clean">
        <form class="form-horizontal" style="max-width: 1000px;">
            <table class="table">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>发布人</th>
                    <th>发布时间</th>
                    <th>附件下载</th>
                </tr>
                </thead>
                <tbody id="notice-list">
                </tbody>
            </table>
            </div>
        </form>
    </div>
</div>
<div class="footer-dark">
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-push-6 item text">
                    <h3>共青团南昌航空大学软件学院委员会</h3>
                    <p>江西省南昌市丰和南大道696号</p>
                    <p>南昌航空大学博学楼E403</p>
                    <p>联系电话：13247088760</p>
                </div>
                <div class="col-md-3 col-md-pull-6 col-sm-4 item">
                    <h3>友情链接</h3>
                    <ul>
                        <li><a href="http://www.nchu.edu.cn/">南昌航空大学官网</a></li>
                        <li><a href="http://linghang.nchu.edu.cn/">南昌航空大学领航网</a></li>
                        <li><a href="http://tuanwei.nchu.edu.cn/">共青团南昌航空大学委员会</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-md-pull-6 col-sm-4 item">
                    <h3>关于我们</h3>
                    <ul>
                        <li><a href="#">共青团南昌航空大学软件学院委员会</a></li>
                        <li><a href="#">开发团队</a></li>
                        <li><a href="#">加入我们</a></li>
                    </ul>
                </div>
                <div class="col-md-12 col-sm-4 item social">
                    <a><i class="iconfont icon-weixin" rel="popover" data-container="body" data-toggle="weixin" data-placement="top" data-content=""></i></a>
                    <a><i class="iconfont icon-weibo" rel="popover" data-container="body" data-toggle="weibo" data-placement="top" data-content=""></i></a>
                </div>
            </div>
            <p class="copyright">版权所有：共青团南昌航空大学软件学院委员会</p>
        </div>
    </footer>
</div>
<script src="js/jquery/jquery.js"></script>
<script src="js/bootstrap/js/bootstrap.js"></script>
<script>
    $(function (){
        loadDate();
        $("[data-toggle='weixin']").popover({
            trigger : 'hover',//鼠标以上时触发弹出提示框
            html:true,//开启html 为true的话，data-content里就能放html代码了
            content:"<img src='img/logo-weixin.jpg' height='200' width='200'>"
        });
        $("[data-toggle='weibo']").popover({
            trigger : 'hover',//鼠标以上时触发弹出提示框
            html:true,//开启html 为true的话，data-content里就能放html代码了
            content:"<img src='img/logo-weibo.jpg' height='200' width='200'>"
        });
    });
    function myfunction_error(){
        alert("暂未开通！")
    }
    function s_click(obj)
    {
        var num = 0;
        for (var i = 0; i < obj.options.length; i++) {
            if (obj.options[i].selected == true) {
                num++;
            }
        }
        if (num == 1) {
            var url = obj.options[obj.selectedIndex].value;
            window.open(url,"_self"); //打开连接方式
        }
    }

    function loadDate() {
        $.post("pages/back/notice_list.action",{},function (obj) {
            $("#notice-list tr:gt(0)").remove();
            for (var x = 0;x <obj.allNotice.length;x++){
                addRow(obj.allNotice[x].title,obj.allNotice[x].name,obj.allNotice[x].file,obj.allNotice[x].time);
            }
        },"json");
    }

    function addRow(title,name,file,time) {
        var str = "<tr>" +
            "<td>"+title+"</td>"+
            "<td>"+name+"</td>"+
            "<td>"+time+"</td>"+
            "<td><a href='<%=basePath%>pages/back/notice_download.action?id="+file+"'>下载</a></td>"+
            "</tr>";
        $("#notice-list").append($(str));
    }
    function myfunction() {
        alert("请先登陆！")
    }
</script>
</body>

</html>

