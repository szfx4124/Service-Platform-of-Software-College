<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>软件学院两委会综合服务平台</title>
</head>
<body>
<script type="text/javascript">
    alert("${msg}") ;
    window.location = "<%=basePath%>${path}" ;
</script>
</body>
</html>
