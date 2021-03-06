/**
 * Created by supersoup on 16/5/17.
 */
$(document).ready(function () {
    var addTitle = $('#addTitle');
    var addContent = $('#addContent');
    var popWrong = $('#popWrong');
    var popRight = $('#popRight');
    var listSure = $("#listSure");
    var chooseMessage = $('#chooseMessage');

    function resetPopTips() {
        popWrong.html('');
        popRight.html('');
    }

    //选择模板
    chooseMessage.change(function () {
        var $this = $(this);
        $('#messageTemple').prop('disabled', false).val($this.val());
    });

    //新增模板

    $(".list-sure-btn2").click(function () {
        listSure.hide(100);
    });

    $('.list-sure-btn1').click(function () {

        if (addTitle.val() === '') {
            popWrong.html('模板标题不能为空!');
        } else {
            resetPopTips();

            $.ajax({
                url: '/smsInfo/newTemp',
                type: 'post',
                data: {
                    'title': addTitle.val(),
                    'content': addContent.val()
                }
            }).done(function (data) {
                var jsonObj = eval("(" + data + ")");
                if (jsonObj.code == 1) {
                    popRight.html('添加成功');
                    window.setTimeout(function () {
                        listSure.hide(100);
                        var str = $('<option value="' + addContent.val() + '">' + addTitle.val() + '</option>');
                        chooseMessage.append(str);
                    }, 1500);
                } else {
                    popRight.html('添加失败');
                    //window.setTimeout(function () {
                    //    listSure.hide(100);
                    //}, 1500);
                }
            }).fail(function () {
                popRight.html('添加失败,请联系管理员!');
            })
        }

    });

    $('#addTemplate').click(function () {
        resetPopTips();

        var $this = $(this);
        listSure.show(100);
    });

    addTitle.focus(resetPopTips);
    addContent.focus(resetPopTips);
});