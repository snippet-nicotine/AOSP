$( document ).ready(function() {
    
	$('form.ajax').on('submit', function(submitEvent) {
		  submitEvent.preventDefault();

		  var form = $(this);
		  var action = form.attr('action');
		  var inputs = {};
		  
		  form.find(':input').each(function() {
		    if(this.name !== "") {
		      inputs[this.name] = $(this).val();
		    }
		  });

		  $.ajax({
		    url : action,
		    data : inputs,
		    method: "POST",
		    success : function(resultat, status, xhr) {
		    	
		    	if(resultat.erreurs){
		    		
		    		//Reset des erreurs
		    		$(".form-group").removeClass("has-error has-feedback");
		    		$(".erreur").remove();
		    		
		    		for(inputName in resultat.erreurs){
		    			console.log(inputName);
		    			// Ajoute une balise d'erreur sur tout les champs qui ont renvoyé une erreur
		    			var inputs     = $("input[name='$inputName']".replace("$inputName", inputName));
		    			var containers = inputs.parents(".form-group");
		    			
		    			if(containers.length > 0){
		    				var container = $(containers[0]);
		    				container.addClass("has-error has-feedback");
		    				container.append('<span class="erreur help-block alert-danger">$message</span></div>'.replace("$message", resultat.erreurs[inputName]));
		    			}
		    			
		    		}
		    		
		    	}
		    	
		    	else{
		    		window.location.reload();
		    	}
		    	
		    }
		  });
		  
		  return false;
		});	
	
});


//<div class=" controls">
//
//<input name="potager.nom" value="" id="formulaire-ajouter_potager_nom" class="form-control" type="text"><span class="glyphicon glyphicon-remove form-control-feedback"></span>
//<span class="help-block alert-danger">Le nom doit être renseigné</span></div>
