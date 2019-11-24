//控制垂直导航栏子功能的隐藏和显示
$(document).ready(function () {
    $("#click_1").click(function () {
        $("#fun1,#fun2,#fun9,#fun11").toggle();
    });
    $("#click_2").click(function () {
        $("#fun3,#fun4,#fun8").toggle();
    });
    $("#click_3").click(function () {
        $("#fun5,#fun6,#fun12,#fun13").toggle();
    });
    $("#click_4").click(function () {
        $("#fun7,#fun10").toggle();
    });
});