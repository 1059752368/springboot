$(function(){
	   $("#username").keyup(function(){
	     var page = "checkName";
	     var value = $(this).val();
	        $.get(
	            page,
	            {"username":value},
	            function(result){
	            	$("#nameCheck").html(result);
	            }
	        );
	   });
	});

$(function(){
	   $("#rstatus").load(function(){
		   var status = $("#rstatus").attr("th:text");
		   if(status==1)
			   $("#rstatus").attr("th:text","启用");
		   else
			   $("#rstatus").attr("th:text","关闭");
	   });
	});

$(function(){
	function edutRetailer(id){
		var message="{'id':'"+id+"'}"
	}
});


