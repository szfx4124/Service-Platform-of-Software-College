$(function () {
    loadDate();
})

function loadDate() {
    $.post("pages/back/yuandan_list.action",{},function (obj) {
        $("#yuandanTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allYuandan.length;x++){
            addRow(obj.allYuandan[x].st_number,obj.allYuandan[x].st_name,obj.allYuandan[x].name,obj.allYuandan[x].team,obj.allYuandan[x].other,obj.allYuandan[x].message);
        }
    },"json");
}

function addRow(st_number,st_name,name,team,other,message) {
    var str = "<tr>" +
        "<td>"+st_number+"</td>"+
        "<td>"+st_name+"</td>"+
        "<td>"+name+"</td>"+
        "<td>"+team+"</td>"+
        "<td>"+other+"</td>"+
        "<td>"+message+"</td>"+
        "<td><a class='btn btn-danger btn-sm' href='pages/back/yuandan_delete.action?st_number=" +
        st_number + "'>删除</a></td>" +
    "</tr>";
    $("#yuandanTable").append($(str));
}