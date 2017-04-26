var id = null;
var user = null;
var rols = null;

// alt der skal køres ved opstart af application!
$(document).ready(function(){
    
});


// logout button menu  
$(document).ready(function() {
  $("#logOut_but").click(function() {    
      var id = null;
      var user = null;
      var rols = null;
      $('#msg').html('');
      $('#login_Bg').show(1000);  
      $('#oprName').html('Username').delay(1000);
      $('#oprRoles').html('Rolle, rolle').delay(1000);
      $('#content_box').html('').delay(1000); 
     // window.location.reload(); måske skal den bruges....
});
  });

// post login data
$(document).ready(function() {
  $("#login_but").click(function() {
      
      var data = $('#login').serializeJSON();    
      
      jQuery.ajax({
		url : "api/opr/verify",
		data : data,
		contentType: "application/json",
		method: 'POST',
		success : function(data){
            if(data == 'Correct password.'){
                $('#msg').css('color','green');
                $('#msg').html(data);
                $('#login_Bg').hide(1000);     
                 
                id = $('#login_oprId').val();
                user = data;
                loadLoginUser(id);
                console.log('user: ' + user.oprId + ', ' + user.oprName + ' successfully logged in.')
            }
            else{
                $('#msg').css('color','red');
                $('#msg').html(data);
                $('#login_Bg').show();
                console.log('Failed to logged in - ' + data)
            }
		},
		error: function(jqXHR, text, error){ 
                $('#msg').css('color','red');
                $('#msg').html('Server fail');
			//    alert(jqXHR.status + text + error);
                console.log('Failed to logged in - ' + data)
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
            $('#table_con').append('<tr id="' + data[i].oprId + '">' + '<td>' + data[i].oprId + '</td>' + '<td>' + data[i].oprName + '</td>' + '<td>' + data[i].oprIni + '</td>' + '<td>' + data[i].oprCpr + '</td>' + '<td id="pass_td">' + data[i].oprPassword + '</td>' + '<td>' + '<button name="' + data[i].oprId + '" class="del_User">Delete</button>' + '</td>' + '<td>' + '<button class="edit_User">Edit</button>' + '</td>' + '</tr>')
	    });
        
        $.getScript( "assets/js/del_Users.js", function( data, textStatus, jqxhr ) {
  console.log( data ); // Data returned
  console.log( textStatus ); // Success
  console.log( jqxhr.status ); // 200
  console.log( "js Load was performed." );
});
        
        $.getScript( "assets/js/edit_Users.js", function( data, textStatus, jqxhr ) {
  console.log( data ); // Data returned
  console.log( textStatus ); // Success
  console.log( jqxhr.status ); // 200
  console.log( "js Load was performed." );
});
        
        console.log('tabel data done');
}); 
} 

// load den user logget ind samt dens roller.
function loadLoginUser(id){
    $.getJSON('api/opr/' + id, function(data) {
        user = data;
        $('#oprName').html(user.oprName).fadeIn(1000);
	    console.log('User ' + user.oprId + ' name:' + user.oprName);
        
        jQuery.ajax({
	  url: "api/opr/getOprRoleList/" + id,
	  type: "GET",
	  contentType: 'text/plain',
	  success: function(resultData) {
          rols = resultData;
	    $('#oprRoles').html(resultData).fadeIn(1000);
	  },
	  error : function(jqXHR, textStatus, errorThrown) {
	  },
	  timeout: 120000,
	});
        console.log('user load done.')
}
             )} 