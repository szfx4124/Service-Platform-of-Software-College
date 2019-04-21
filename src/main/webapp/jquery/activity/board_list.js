$(function () {
    loadDate();
})

function loadDate() {
    $.post("pages/back/board_list.action",{},function (obj) {
        $("#boardTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allBoard.length;x++){
            addRow(obj.allBoard[x].title,obj.allBoard[x].name,obj.allBoard[x].content,obj.allBoard[x].date);
        }
    },"json");
}

function addRow(title,name,content,date) {
    var str = "<tr>" +
        "<td>"+title+"</td>"+
        "<td>"+name+"</td>"+
        "<td>"+content+"</td>"+
        "<td>"+date+"</td>"+
    "</tr>";
    $("#boardTable").append($(str));
}