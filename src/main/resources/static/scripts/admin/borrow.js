$(document).ready(function () {
    $("button").click(function () {
        if(confirm("确认借书?")) {
            var rId = document.getElementById('rId').value;
            var tr = $(this).closest("tr");
            var bName= tr.find("td:eq(0)").text();
            var bAuthor= tr.find("td:eq(1)").text();
            var bId = $(this).val();
            borrowBooks(bId, rId,bName,bAuthor);
        }
    });
});


function borrowBooks(bId,rId,bName,bAuthor) {
    $.ajax({
        async : false,
        type : "post",
        url : "/admin/borrows_books",
        dataType : "json",
        data: {bId:bId,rId:rId,bName:bName,bAuthor:bAuthor},
        success:function (data) {
            var a = JSON.stringify(data)
            if(a==="false"){
                alert("借书次数已达上限");
            }else {
                alert("借书成功");
                location.reload();
                //window.history.go(-1);
            }
        },
        error:function (data) {
        }
    });
}
