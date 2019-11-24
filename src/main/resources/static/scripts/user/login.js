$(document).ready(function () {
    $("#form1").validate({
        rules:{  //校验规则
            cardNumber:{
                required:true
            },
            password:{
                required: true,
                minLength: 6
            }
        } ,
        messages:{ //提示
            cardNumber:{
                required: "请输入借书证号",
            },
            password:{
                required: "请输入密码",
                minLength: "密码长度不能小于6位"
            }
        }
    });

    // $("#submit").click(function () {
    //     login();
    // });
});
//
// function login() {
//     $.ajax({
//         async : false,
//         type : "post",
//         url : "/reader/userLogin",
//         dataType : "json",
//         data: $('#form1').serialize(),
//         success: function (data) {
//             alert("登录成功")
//             location.href="http://localhost:8080/reader/to_index";
//         },
//         error:function (data) {
//             alert("用户名或密码错误");
//             window.history.go(-1);
//         }
//     });
// };
