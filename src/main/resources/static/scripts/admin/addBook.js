$(document).ready(function () {

    //查找所有图书种类，并给select选择框赋值
   // findAllBookCategory();

    //给选择框赋值
    findAllBookCategory();
    //插入图书编号
    addBookCode();

    $("#btn1").click(function () {
        if(validateAddBookForm().form()) //  表单验证
        addBook();//异步添加书籍
    });
});

function validateAddBookForm() {
    return $("#addBookForm").validate({
        rules:{
            bookCode:{
                required:true
            },
            bookName:{
                required:true
            },
            bookAuthor:{
                required:true
            },
            bookPublish:{
                required:true
            },
            bookDatePress:{
                required:true
            },
            bookIsbn:{
                required:true
            },
            bookLanguage:{
                required:true
            },
            bookCategory:{
                required:true
            },
            bookPrice:{
                required:true
            },
            bookIntroduction:{
                required:true
            }
        } ,
        messages:{

            bookCode:{
                required:"请输入图书编号"
            },
            bookName:{
                required:"请输入书名"
            },
            bookAuthor:{
                required:"请输入作者"
            },
            bookPublish:{
                required:"请输入出版社"
            },
            bookDatePress:{
                required:"请输入出版日期"
            },
            bookIsbn:{
                required:"请输入isbn号"
            },
            bookLanguage:{
                required:"请输入语言"
            },
            bookCategory:{
                required:"请选择种类"
            },
            bookPrice:{
                required:"请输入价格"
            },
            bookIntroduction:{
                required:"请输入简介"
            }
        }
    });
}

function addBook() {
    $.ajax({
        async : false,
        type : 'post',
        url : '/book/add_book',
        data : $('#addBookForm').serialize(),
        success : function(data) {
            var a = JSON.stringify(data)
            if(a==="false"){
                alert("添加失败");
            }else {
                alert("添加成功");
            }
        },
        error : function(data) {
        }
    });
}

function findAllBookCategory() {
    $.ajax({
        async : false,
        type : "post",
        url : "/book/find_all_book_category",
        dataType : "json",
        success: function (data) {
            console.log(data);
            $("select[name='b_catalog']").empty();
            $("select[name='b_catalog']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].c_id+'">';
                html +=data[i].c_name + '</option>';
                $("select[name='b_catalog']").append(html);
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
}

function addBookCode() {
    $.ajax({
        async : false,
        type : "post",
        url : "/book/add_book_code",
        dataType : "json",
        success: function (data) {
            console.log(data);
            $("select[name='b_code_last']").empty();
            $("select[name='b_code_last']").append('<option value="">——请选择——</option>');
            for(var i=0;i<data.length;i++){
                var html ='<option value="'+data[i].b_code+'">';
                html +=data[i].b_code + '</option>';
                $("select[name='b_code_last']").append(html);
            }
        },
        error:function (data) {
            alert(data.result);
        }
    });
}