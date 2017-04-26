
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
         $(this).css('background-color', 'gray'); 
	  },
	  error : function(jqXHR, textStatus, errorThrown) {
          console.log(resultData);
	  },
	  timeout: 120000,
	});
    }); 
});
