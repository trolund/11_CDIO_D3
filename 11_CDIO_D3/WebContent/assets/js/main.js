/* login in funktion
function login(){
var id = document.getElementById("Id").value;
var pass = document.getElementById("password").value;
var dataString ="name="+name + "pass=" + pass;

jQuery.ajax({
    type: "post",
    url: "/api/opr/verify",
    data: dataString,
    cache: false,
    success: function(html){
        $("#msg").html("velkommen!");
    }
    
})
return false;
}

*/
var id = 1;
var user = null;

$(document).ready(function() {
  $("#login_but").click(function() {
   
      jQuery.ajax({
		url : "/api/opr/verify",
		data : $('#form').serializeJSON(),
		contentType: "application/json",
		method: 'POST',
		success : function(data){
			alert(data);
		},
		error: function(jqXHR, text, error){
			alert(jqXHR.status + text + error);
		}
	});
});   
  });


// Menu mobile button 
$(document).ready(function() {
  $("#menu_but").click(function() {
    $("#sidepanel ul").toggleClass("on");
    $("#sidepanel").toggleClass("on_sidepanel");
    $("#menu_but").toggleClass("rot");
  });
});

// User button menu 
$(document).ready(function() {
  $("#user_but").click(function() {       
    $( "#content_box" ).load( 'adduser.html');
          
    jQuery.ajax({
      url: "/api/opr/getOprList",
      type: "GET",
      contentType: 'text/plain',
      success: function(resultData) {
        $("#table_con").html(resultData);
      },
      error : function(jqXHR, textStatus, errorThrown) {
      },

      timeout: 120000,
    });          
  });
});




// Ajax get user data 
jQuery.ajax({
  url: "api/opr/" + id,
  type: "GET",
  contentType: 'text/plain',
  success: function(resultData) {
    $('#oprName').html(resultData);
  },
  error : function(jqXHR, textStatus, errorThrown) {
  },
  timeout: 120000,
});

jQuery.ajax({
	  url: "api/opr/getOprRoleList/" + id,
	  type: "GET",
	  contentType: 'text/plain',
	  success: function(resultData) {
	    $('#oprRoles').html(resultData);
	  },
	  error : function(jqXHR, textStatus, errorThrown) {
	  },
	  timeout: 120000,
	});



//function findById(id) {
//	console.log('find opr by id: ' + id);
//	jQuery.ajax({
//		type: 'GET',
//		url: "api/opr/getOprRoleList/" + id,
//		dataType: "json",
//		success: function(data){
//			user = data;
//			console.log('findById success: ' + user.name);
//		},
//	    error : function(jqXHR, textStatus, errorThrown){
//          console.log('fejl!')
//          
//      }
//	});
//}