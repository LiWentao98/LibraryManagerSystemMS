$(document).ready(function () {

    //给选择框赋值
    findAllBookCategory();

    $("#bookCategoryForm").validate({
        rules:{
            c_id:{
                required:true
            }
        } ,
        messages:{
            c_id:{
                required:"请选择图书类别"
            }
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

