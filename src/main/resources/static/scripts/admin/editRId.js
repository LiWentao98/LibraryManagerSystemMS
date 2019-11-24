$(document).ready(function () {

    $("#btn1").click(function () {
        if(confirm("确认挂失?")){
            var r_id=$(this).val();
            // alert(userId);
            closeVoucher(r_id);
            //$(this).parent().parent().remove();
        }
    });

    $("#btn2").click(function () {
        if(confirm("确认解除?")){
            var r_id=$(this).val();
            // alert(userId);
            relieveCloseVoucher(r_id);
            //$(this).parent().parent().remove();
        }
    });
});


function closeVoucher(r_id) {
    $.ajax({
        async: false,
        type: "post",
        url: "/admin/close_voucher",
        dataType : "json",
        data: {r_id:r_id},
        success: function (data) {
            var a = JSON.stringify(data)
            if(a==="false"){
                alert("挂失失败");
            }else {
                alert("挂失成功");
            }
            window.history.go(-1);
        },
        error: function (data) {
        }
    });
}

function relieveCloseVoucher(r_id) {
    $.ajax({
        async: false,
        type: "post",
        url: "/admin/relieve_close_voucher",
        dataType : "json",
        data: {r_id:r_id},
        success: function (data) {
            var a = JSON.stringify(data)
            if(a==="false"){
                alert("解除失败");
            }else {
                alert("解除成功");
            }
            window.history.go(-1);
        },
        error: function (data) {
        }
    });
}



