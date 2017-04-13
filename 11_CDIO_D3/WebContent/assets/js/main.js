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

var id = 1;
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



