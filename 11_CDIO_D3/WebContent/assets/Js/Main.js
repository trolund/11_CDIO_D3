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
            url: "CDIO_D3/api/opr/get",
            type: "GET",

            contentType: 'application/json; charset=utf-8',
            success: function(resultData) {
                console.log('success', resultData);
            },
            error : function(jqXHR, textStatus, errorThrown) {
            },

            timeout: 120000,
        });
