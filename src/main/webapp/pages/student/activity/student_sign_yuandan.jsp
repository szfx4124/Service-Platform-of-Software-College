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
        <form action="<%=basePath%>pages/back/yuandan_insert.action" method="post" id="insertYuandan">
            <h2 class="text-center">软件学院2019年元旦晚会</h2>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="yuandan">
                    <div class="form-group"><input type="text" name="st_number" value="<%=request.getSession().getAttribute("st_number")%>" class="form-control" readonly/></div>
                    <div class="form-group"><input type="text" name="st_name" value="<%=request.getSession().getAttribute("st_name")%>" class="form-control" readonly/></div>
                    <div class="form-group has-success"><input type="text" name="name" placeholder="节目名称" class="form-control" /></div>
                    <div id="team_change" class="form-group has-success"><select class="form-control" name="team" id="team" onchange="changefun()"><optgroup label="是否团队参与"><option value="是" selected>团队参与</option><option value="否">个人参与</option></optgroup></select></div>
                    <div class="form-group has-success"><input type="text" id="other" name="other" placeholder="其他参与人员学号" class="form-control"></div>
                    <div class="form-group has-success"><textarea rows="14" name="message" placeholder="备注" class="form-control"></textarea></div>
                </div>
            </div>
            <div class="form-group has-success"><button class="btn btn-primary" type="submit">提交</button></div>
        </form>
    </div>
<jsp:include page="/pages/student/student_footer.jsp"/>
<script>
    function changefun() {
        var value = $("#team").val();
        if (value === "否"){
            $('#other').remove()
        }
    }
</script>
</body>

</html>

