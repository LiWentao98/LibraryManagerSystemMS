$(document).ready(function () {

    //给选择框赋值
    findAllBookCategory();

    $("button").click(function () {
        if(confirm("确认预约?")){
            var tr = $(this).closest("tr");
            var bName= tr.find("td:eq(0)").text();
            var bAuthor= tr.find("td:eq(1)").text();
            var bId = $(this).val();
            borrowBook(bId,bName,bAuthor);
        }
    });
});

function findAllBookCategory() {
    $.ajax({
        async : false,
        type : "post",
        url : "/book/find_all_book_category",
        dataType : "json",
        success: function (data) {
            console.log(data);
            $("select[name='c_id']").empty();
            $("select[name='c_id']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].c_id+'">';
                html +=data[i].c_name + '</option>';
                $("select[name='c_id']").append(html);
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
}

function borrowBook(bId,bName,bAuthor) {
    $.ajax({
        async : false,
        type : "post",
        url : "/reader/reserve_borrow_book",
        dataType : "json",
        data: {bId:bId,bName:bName,bAuthor:bAuthor},
        success:function (data) {
            var a = JSON.stringify(data);
            if(a==="false"){
                alert("借书次数超过上限,请先还书");
            }else {
                alert("预约成功");
                location.reload();
            }
        },
        error:function (data) {
        }
    });
}
