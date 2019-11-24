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
        if(confirm("确认续借?")){
            var tr = $(this).closest("tr");
            var rId= tr.find("td:eq(0)").text();
            var bCT= tr.find("td:eq(5)").text();
            var borrowId=$(this).val();
            // alert(userId);
            continueBook(borrowId,rId,bCT);
        }
    });

});

//ajax
function continueBook(borrowId,rId,bCT) {
    $.ajax({
        async : false,
        type : "post",
        url : "/admin/continue_book",
        dataType : "json",
        data: {borrowId:borrowId,rId:rId,bCT:bCT},
        success: function (data) {
            var a = JSON.stringify(data)
            if(a==="false"){
                alert("该用户不满足续借条件");
            }else {
                alert("续借成功");
                $(this).parent().parent().remove();
            }
        },
        error:function (data) {
        }
    });
}