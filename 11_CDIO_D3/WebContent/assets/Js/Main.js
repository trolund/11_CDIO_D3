// menu mobil button 
    $(document).ready(function(){
      $("#menu_but").click(function(){
        $("#sidepanel ul").toggleClass("on");
        $("#sidepanel").toggleClass("on_sidepanel");
        $("#menu_but").toggleClass("rot");
      });
    });

// ajax get user data 

jQuery.ajax({
            url: "/rest/abc",
            type: "GET",

            contentType: 'application/json; charset=utf-8',
            success: function(resultData) {
                //here is your json.
                  // process it

            },
            error : function(jqXHR, textStatus, errorThrown) {
            },

            timeout: 120000,
        });
