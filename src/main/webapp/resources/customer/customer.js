/**
 * Created by supersoup on 16/5/17.
 */
$(document).ready(function () {
    $('#chooseMessage').change(function (){
        var $this = $(this);
        $('#messageTemple').prop('disabled', false).val($this.val());
    });
});