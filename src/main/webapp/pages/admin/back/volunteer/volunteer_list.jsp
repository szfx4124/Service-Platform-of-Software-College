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
                <a class="navbar-brand">待认定志愿服务</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="请输入...">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
        <div class="col-md-12">
            <table class="table table-bordered table-hover" id="volunteerTable">
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>认定名称</th>
                    <th>日期</th>
                    <th>认定学分</th>
                    <th>辅助认定材料</th>
                    <th>操作</th>
                </tr>
            </table>
        </div>
        <div class="form-group">
            <div class="tools col-md-9">
                <button type="button" class="btn btn-success" id="excell"  onclick="method5('volunteerTable')">导出信息表</button>
            </div>
            <div class="col-md-3">
                <nav aria-label="paper">
                    <ul class="pager">
                        <li><a href="#">上一页</a></li>
                        <li><a href="#">下一页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </nav>
</div>
<jsp:include page="/pages/admin/footer.jsp"/>
<script src="../../../../jquery/jquery.validate.min.js"></script>
<script src="../../../../jquery/additional-methods.min.js"></script>
<script src="../../../../jquery/jquery.metadata.js"></script>
<script src="../../../../jquery/Message_zh_CN.js"></script>
<script>
    $(function () {
        loadDate();
    })

    function loadDate() {
        $.post("pages/back/volunteer_list.action",{},function (obj) {
            $("#volunteerTable tr:gt(0)").remove();
            for (var x = 0;x <obj.allVolunteer.length;x++){
                addRow(obj.allVolunteer[x].st_number,obj.allVolunteer[x].st_name,obj.allVolunteer[x].date,obj.allVolunteer[x].name,obj.allVolunteer[x].score,obj.allVolunteer[x].file);
            }
        },"json");
    }

    function addRow(st_number,st_name,date,name,score,file) {
        var str = "<tr>" +
            "<td>"+st_number+"</td>"+
            "<td>"+st_name+"</td>"+
            "<td>"+name+"</td>"+
            "<td>"+date+"</td>"+
            "<td>"+score+"</td>"+
            "<td><a href='<%=basePath%>pages/back/volunteer_download.action?id="+file+"'>下载</a></td>"+
            "<td> <a class='btn btn-danger btn-sm' href='pages/back/volunteer_delete.action?st_number=" +
            st_number + "'>删除</a> <a class='btn btn-success btn-sm' href='pages/back/volunteer_confirm.action?st_number=" +
            st_number + "'>确认</a> </td>" +
            "</tr>";
        $("#volunteerTable").append($(str));
    }
    //打印表格
    var idTmr;
    function  getExplorer() {
        var explorer = window.navigator.userAgent ;
        //ie
        if (explorer.indexOf("MSIE") >= 0) {
            return 'ie';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if (explorer.indexOf("Chrome") >= 0) {
            return 'Chrome';
        }
        //Opera
        else if (explorer.indexOf("Opera") >= 0) {
            return 'Opera';
        }
        //Safari
        else if (explorer.indexOf("Safari") >= 0) {
            return 'Safari';
        }
    }
    function method5(tableid) {
        if (getExplorer() == 'ie') {
            var curTbl = document.getElementById(tableid);
            var oXL = new ActiveXObject("Excel.Application");
            var oWB = oXL.Workbooks.Add();
            var xlsheet = oWB.Worksheets(1);
            var sel = document.body.createTextRange();
            sel.moveToElementText(curTbl);
            sel.select();
            sel.execCommand("Copy");
            xlsheet.Paste();
            oXL.Visible = true;

            try {
                var fname = oXL.Application.GetSaveAsFilename("Excel.xls",
                    "Excel Spreadsheets (*.xls), *.xls");
            } catch (e) {
                print("Nested catch caught " + e);
            } finally {
                oWB.SaveAs(fname);
                oWB.Close(savechanges = false);
                oXL.Quit();
                oXL = null;
                idTmr = window.setInterval("Cleanup();", 1);
            }

        } else {
            tableToExcel(tableid)
        }
    }
    function Cleanup() {
        window.clearInterval(idTmr);
        CollectGarbage();
    }
    var tableToExcel = (function() {
        var uri = 'data:application/vnd.ms-excel;base64,', template = '<html><head><meta charset="UTF-8"></head><body><table  border="1">{table}</table></body></html>', base64 = function(
            s) {
            return window.btoa(unescape(encodeURIComponent(s)))
        }, format = function(s, c) {
            return s.replace(/{(\w+)}/g, function(m, p) {
                return c[p];
            })
        }
        return function(table, name) {
            if (!table.nodeType)
                table = document.getElementById(table)
            var ctx = {
                worksheet : name || 'Worksheet',
                table : table.innerHTML
            }
            window.location.href = uri + base64(format(template, ctx))
        }
    })()
</script>
</body>
</html>