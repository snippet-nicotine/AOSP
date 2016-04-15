<!-- Modifier le potager -->
	<div class="modal fade ${ isModifier ? 'visible' : '' }" id="modal-modifier" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modifier le potager</h4>
				</div>
				<div class="modal-body">
				
				<form class="form well" id="formulaire-modifier" method="POST" action="">
		  
				  <div class="form-group ${ erreurNom != null ? 'has-error' : '' }">
				    <label for="nom">Nom</label>
				    <input type="text" class="form-control" id="modifier-nom" name="modifier-nom" placeholder="Nom"
				    		data-toggle="tooltip" 
				    		title="${ erreurNom != null ? erreurNom : 'Entrez le nom du potager' }">
				  </div>
				  
				  <div class="form-group ${ erreurDimension != null ? 'has-error' : '' }">
				  
				    <label for="longueur">Dimension</label>
				    <input type="number" class="form-control" id="modifier-longueur" name="modifier-longueur" placeholder="Longueur"
				    		data-toggle="tooltip" 
				    		title="${ erreurDimension != null ? erreurDimension : 'Entrez la largeur du potager' }">				    
				    <input type="number" class="form-control" id="modifier-largeur"  name="modifier-largeur"  placeholder="Largeur"
				    		data-toggle="tooltip" 
			    			title="${ erreurDimension != null ? erreurDimension : 'Entrez la longueur du potager' }">
				    
				  </div>
				  
				  <div class="form-group ${ erreurCodepostal != null ? 'has-error' : '' }">
				    <label for="codePostal">Code Postal</label>
				    <input type="text" class="form-control" id="modifier-codePostal" name="modifier-codePostal" placeholder="Code Postal"
				    		data-toggle="tooltip" 
			    			title="${ erreurCodepostal != null ? erreurCodepostal : 'Entrez le code postal du potager (5 chiffres)' }">
				  </div>				  		  				  
				</form>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
					<button data-button-id="" name="modifier" type="button" class="bouton-modifier btn btn-primary">Mettre à jour</button>
				</div>
			</div>
		</div>
	</div>