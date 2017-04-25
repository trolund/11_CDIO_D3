var id = 1;
var user = null;
var rols = null;

// alt der skal køres ved opstart af application!
$(document).ready(function(){
    loadLoginUser(id);
});

// post login data - virker ikke endnu
$(document).ready(function() {
  $("#login_but").click(function() {
   
      jQuery.ajax({
		url : "api/opr/verify",
		data : $('#form').serializeJSON(),
		contentType: "application/json",
		method: 'POST',
		success : function(data){
			alert('Login data send, data: ' + data);
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
    $("#content_box").load('adduser.html');
      
    loadUsers();
});
  });

// hent liste af users og oversæt dem til tabel
function loadUsers(){
    $('#table_con').empty();
    $('#table_con').append('<tr><td>Id</td><td>Name</td><td>Initials</td><td>Cpr</td><td>passwords</td><td>Delete</td><td>Edit</td></tr>');
    
    $.getJSON('api/opr/getOprList', function(data) {
	    console.log('Users loaded');
	
        $.each(data, function(i, item) {
            $('#table_con').append('<tr>' + '<td>' + data[i].oprId + '</td>' + '<td>' + data[i].oprName + '</td>' + '<td>' + data[i].oprIni + '</td>' + '<td>' + data[i].oprCpr + '</td>' + '<td id="pass_td">' + data[i].oprPassword + '</td>' + '<td>' + '<button id="del_User_' + data[i].oprId + '">Delete</button>' + '</td>' + '<td>' + '<button id="edit_User_' + data[i].oprId + '">Edit</button>' + '</td>' + '</tr>')
	    });
}); 
} 

// load den user logget ind samt dens roller.
function loadLoginUser(id){
    $.getJSON('api/opr/' + id, function(data) {
        user = data;
        $('#oprName').html(user.oprName);
	    console.log('User ' + user.oprId + ' name:' + user.oprName);
        
        jQuery.ajax({
	  url: "api/opr/getOprRoleList/" + id,
	  type: "GET",
	  contentType: 'text/plain',
	  success: function(resultData) {
          rols = resultData;
	    $('#oprRoles').html(resultData);
	  },
	  error : function(jqXHR, textStatus, errorThrown) {
	  },
	  timeout: 120000,
	});
        console.log('user load done.')
}
             )} 