
//Delete users 
$(document).ready(function(){
   $('.del_User').click(function(){
       
        var id = $(this).prop('name');

        console.log('Try to delete user with id: ' + id);  
        
     jQuery.ajax({
	  url: "api/opr/deleteOpr",
	  type: "POST",
      data : id,
	  contentType: "application/json",
	  success: function(resultData) {
         console.log(resultData);
        if(resultData == true){
            console.log('User successfully deleted.');
         $('#' + id).hide(500);
        }
          else{
              $('#' + id).css('background-color', 'yellow').fadeIn( 400 ); 
          }
	  },
	  error : function(jqXHR, textStatus, errorThrown) {
          console.log("Id [" + id + "] does not exist.");
	  },
	  timeout: 120000,
	});
    }); 
});
