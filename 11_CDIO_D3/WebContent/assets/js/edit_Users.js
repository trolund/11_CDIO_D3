// edit user button
$(document).ready(function() {
    $(".edit_User").click(function(){
        
        var id = $(this).prop('name');
        
        console.log(id);
        
        $.getJSON('api/opr/' + id, function(data) {
	    console.log('User with id: ' + id + "loaded for edit");
        
        $('#oprId').val(data.oprId);
        $('#oprName').val(data.oprName);
        $('#oprIni').val(data.oprIni);
        $('#oprCpr').val(data.oprCpr);
        $('#oprPassword').val(data.oprPassword);
            $('#oprRole1').val(data.oprRole1);
            $('#oprRole2').val(data.oprRole1);
            $('#oprRole3').val(data.oprRole1);
            $('#oprRole4').val(data.oprRole1);
        
        console.log(data + "added to form")
    }); 
        $("#AddUser_Box").toggleClass("display");
});
  });  