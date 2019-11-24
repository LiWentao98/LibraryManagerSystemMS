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
        var borrowId= tr.find("td:eq(0)").text();
        var rId= tr.find("td:eq(3)").text();
        solveReserve(borrowId,rId);
    });
});


//修改用户的ajax方法
function solveReserve(borrowId,rId) {
    $.ajax({
        async: false,
        type: 'post',
        url: '/admin/to_solve_reserve',
        data: {borrowId:borrowId,rId:rId},
        dataType : "json",
        success: function (data) {
            var a = JSON.stringify(data);
            if(a==="false") {
                alert("借书次数超过上限,请先还书");
            }
            else {
                alert("处理成功");
                $(this).parent().parent().remove();
            }
            // window.history.go(-1);
        },
        error: function (data) {
        }
    });
}



