/**
 * Created by supersoup on 16/5/18.
 */

$(document).ready(function () {
    var id;

    $(".list-sure-btn2").click(function () {
        $("#listSure").hide(100);
    });

    $('.list-sure-btn1').click(function () {
        //请在此处写上具体的url
        window.location = '' + id;
    });

    $(document).on('click', '.list-delete', function () {
        var $this = $(this);
        id = $this.attr('data-value');
        $("#listSure").show(100);
    });

});
