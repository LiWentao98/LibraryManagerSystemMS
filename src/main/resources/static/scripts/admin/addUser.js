// $(document).ready(function () {
//
//     $("#btn_addUser").click(function () {
//         if(validateAddUserForm().form()){
//             addUser();
//         }
//     });
// });
//
//
// //添加用户的ajax方法
// function addUser() {
//     $.ajax({
//         async: false,
//         type: 'post',
//         url: '/admin/add_user',
//         data: $('#addUserForm').serialize(),
//         success: function (data) {
//             alert("添加成功");
//             location.href="http://localhost:8080/reader/to_login";
//         },
//         error: function (data) {
//             alert("添加失败");
//         }
//     });
// };
//
//
// function validateAddUserForm() {
//         return $("#addUserForm").validate({
//             rules:{
//                 readerType:{
//                     required:true
//                 },
//                 readerName:{
//                     required:true
//                 },
//                 readerSex:{
//                     required:true
//                 },
//                 readerPhone:{
//                     required:true
//                 },
//                 readerId:{
//                     required:true
//                 },
//                 readerEmail:{
//                     required:true
//                 },
//                 readerDept:{
//                     required:true
//                 },
//                 readerDateReg:{
//                     required:true
//                 }
//             },
//             messages:{
//                 readerType:{
//                     required:"请选择用户类型"
//                 },
//                 readerName:{
//                     required:"请输入用户姓名"
//                 },
//                 readerSex:{
//                     required:"请选择性别"
//                 },
//                 readerPhone:{
//                     required:"请输入电话号码（用户名）"
//                 },
//                 readerId:{
//                     required:"请输入学号（借书证）"
//                 },
//                 readerEmail:{
//                     required:"请输入电子邮箱"
//                 },
//                 readerDept:{
//                     required:"请输入所在单位"
//                 },
//                 readerDateReg:{
//                     required:"请选择办证日期"
//                 }
//             }
//         })
// };