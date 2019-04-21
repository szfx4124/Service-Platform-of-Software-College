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
        </form>
    </div>
<jsp:include page="/pages/student/student_footer.jsp"/>
<script>
    $(function (){
        loadDate();
    });
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
            "<td> <a class='btn btn-danger btn-sm' href='pages/back/notice_delete.action?title="+
            title+"'>删除</a> </td>"+
            "</tr>";
        $("#notice-list").append($(str));
    }
</script>
</body>

</html>

