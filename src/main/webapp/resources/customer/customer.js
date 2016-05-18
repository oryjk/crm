/**
 * Created by supersoup on 16/5/17.
 */
$(document).ready(function () {
    $('#chooseMessage').change(function (){
        var $this = $(this);
        $('#smsContent').val($this.val());
    });
});