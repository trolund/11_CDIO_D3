// menu mobil button 
    $(document).ready(function(){
      $("#menu_but").click(function(){
        $("#sidepanel ul").toggleClass("on");
        $("#sidepanel").toggleClass("on_sidepanel");
        $("#menu_but").toggleClass("rot");
      });
    });

// ajax get user data 

var oprname = $('#oprname');
jQuery.ajax({
            url: "api/opr/test",
            type: "GET",

            contentType: 'application/json; charset=utf-8',
            success: function(resultData) {
                oprname.append("trolle");
            },
            error : function(jqXHR, textStatus, errorThrown) {
            },

            timeout: 120000,
        });
