$(document).ready(function () {

    $("#btn_editUser").click(function () {
            editUser();
    });
});


//修改用户的ajax方法
function editUser() {
    $.ajax({
        async: false,
        type: 'post',
        url: '/admin/edit_user',
        data: $('#editUserForm').serialize(),
        success: function (data) {
            var a = JSON.stringify(data)
            if(a==="false"){
                alert("修改失败");
            }else {
                alert("修改成功");
            }
        },
        error: function (data) {
        }
    });
};



