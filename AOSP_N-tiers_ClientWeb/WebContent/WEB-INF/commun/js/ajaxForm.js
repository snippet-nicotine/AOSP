$('form .ajax').on('submit' , function(event){
	
	event.preventDefault();
	var form = $($this);
	var action = form.attr('action');
	var inputs = {};
	
	form.find('inputs').each(function(){
		if(this.name !== ""){
			inputs[this.name] = $(this).val();
		}
	});
	
	$.ajax({
		url:action,
		data: inputs,
		success: function(e, status, xhr){
			//TODO: traiter e
		}
		
	});
	
	return false;
	
});