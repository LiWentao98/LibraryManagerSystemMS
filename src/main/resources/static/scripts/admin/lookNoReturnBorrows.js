$(document).ready(function () {
    //检查能否再点击上一页，下一页
    var lab1=$("#lab1").html().trim();//获取当前页码
    var lab2=$("#lab2").html().trim();//获取总页码
    // alert(lab1+" *****"+lab2);
    $("#prePage").click(function () {
        if(lab1==1){
            alert("已经是第一页了!");
            return false;
        }
        return true;
    });
    $("#nextPage").click(function () {
        if(lab1==lab2){
            alert("已经是最后一页了!");
            return false;
        }
        return true;
    });

    $("button").click(function () {
        var tr = $(this).closest("tr");
        var rId= tr.find("td:eq(7)").text();
        var bId= tr.find("td:eq(8)").text();
        var borrowId=$(this).val();
        returnBook(borrowId,rId,bId);
        //alert(rId);
        //alert(bId);
    });
});

function returnBook(borrowId,rId,bId) {
    $.ajax({
        async: false,
        type: 'post',
        url: '/admin/return_book',
        data: {borrowId:borrowId,rId:rId,bId:bId},
        success: function (data) {
            var a = JSON.stringify(data);
            if(a==="false"){
                alert("还书失败");
            }else {
                alert("还书成功");
                $(this).parent().parent().remove();
                location.reload();
            }

            // window.history.go(-1);
        },
        error: function (data) {
        }
    });
}

