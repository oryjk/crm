/**
 * Created by zhoujialiang on 16/5/9.
 */

$(document).ready(function () {
    var id;

    $('.list-sure-btn1').click(function () {
        //请在此处写上具体的url
        window.location = '/contact/delete?id=' + id;
    });

    $(".list-sure-btn2").click(function () {
        $("#listSure").hide(100);
    });

    $(".delete-btn").click(function () {
        var $this = $(this);
        id = $this.attr('data-value');
        $("#listSure").show(100);
    });
})

