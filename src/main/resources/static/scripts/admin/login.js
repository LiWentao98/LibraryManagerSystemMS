$(document).ready(function () {


});

var current = null;
document.querySelector('#adminName').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: 0,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#password').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -336,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#submit').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -730,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '530 1386',
            duration: 700,
// function adminLogin(adminName,password) {
//     $.ajax({
//         async : false,
//         type : "post",
//         url : "/admin/admin_login",
//         dataType : "json",
//         data : {adminName:adminName,password:password},
//         success: function (data) {
//             var a = JSON.stringify(data);
//             if(a==="false"){
//                 alert("用户名或密码错误");
//             }else {
//                 alert("登陆成功");
//                 window.location.href = "/admin/to_admin_index";
//             }
//         },
//         error:function (data) {
//             alert(data.result);
//         }
//     });
// }
            easing: 'easeOutQuart'
        }
    });
});
//
