/**
 * Created by zhoujialiang on 16/5/9.
 */

$(document).ready(function () {
    var sort = $("#sort").attr('value');
    var fromOrderPage = $("#fromOrderPage").attr('value');
    var id;

    $('.list-sure-btn1').click(function () {
        //请在此处写上具体的url
        window.location = '/smsInfo/delete?id=' + id + "&fromOrderPage=" + fromOrderPage;
    });

    $(".list-sure-btn2").click(function () {
        $("#listSure").hide(100);
    });

    $(".delete-btn").click(function () {
        var $this = $(this);
        id = $this.attr('data-value');
        $("#listSure").show(100);
    });

    switch (sort) {
        case "1":
            $("#pup").addClass("sort-choose");
            break;
        case "2":
            $("#pdown").addClass("sort-choose");
            break;
        case "3":
            $("#sup").addClass("sort-choose");
            break;
        case "4":
            $("#sdown").addClass("sort-choose");
            break;
        default:
            $("#pup").addClass("sort-choose");
    }
    ;
});

