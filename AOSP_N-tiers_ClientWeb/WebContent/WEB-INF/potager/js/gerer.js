/*
 * author: Nicolas LAMBERT
 * 
 */

// TODO: Refactoriser, car l'intégration de jQuery a chamboulé le code...
// TODO: Généraliser ce script pour tout type de form

window.onload = function(){

	
	// Init du modal
	var isModalVisible = $("#modal-modifier").hasClass("visible");
	console.log(isModalVisible);
	
	
	if( isModalVisible ) {
		$('#modal-modifier').modal('show') ;    
	}
	
	gestionPotager.init();


}

/**
 * Controlleur de la page gestion de potager
 * $variable = variable de type jquery
 */
var gestionPotager = {
		
		baseUrl: "/aosp/potagers",
		form: null,
		self: this,		
		
		init: function() {
			
			this.form         = $("#formulaire-ajouter");
			this.formModifier = $("#formulaire-modifier");
			this.initEvents();						
			
		},
		
		initEvents : function(){
			
			var form = this.form;
			var obj  = this;
			pageContext = $("#context").html();
			
			var $id = $(form).find('input[name="potager.idPotager"]');
			
			// S'il n'y a pas de valeurs dans id, alors on ajoute, sinon on modifie				
			obj.setFormBoutonAction( $(form), $id );

			$id.change('change', function(event){	
				obj.setFormBoutonAction( $(form) , $(this) );
			} );
									
			$('.bouton-afficher-modifier').on('click', function(e){
				
				e.preventDefault();
				var $ligne = $(this).parents("tr");
				var $form  = $("#formulaire-ajouter");
				
				$('input[name="potager.nom"]').val( $ligne.data("potagerNom") );
				$('input[name="potager.longueur"]').val( $ligne.data("potagerLongueur") );
				$('input[name="potager.largeur"]').val( $ligne.data("potagerLargeur") );
				$('input[name="potager.codePostal"]').val( $ligne.data("potagerCodepostal") );
				$form.find('input[name="potager.idPotager"]').val($ligne.data("potagerId") ).change();
								
				obj.changerInputsClass( $("#formulaire-ajouter"), "has-warning" );
												
			});
			
			$('.bouton-modifier').on('click', function(e){
								
				e.preventDefault();
				var id  = $(this).data("buttonId");
				obj.modifier(id);
				
				
			});
			
			$('.bouton-supprimer').on('click', function(e){
				
				e.preventDefault();
				var id  = $(this).data("buttonId");
				
				obj.supprimer(id);				
			});
			
		},
		/**
		 * Modifie la classe de tout les inputs du formulaire concerné
		 * 
		 */		
		changerInputsClass: function($form, classNames){
			
			// On supprime toutes les éventuelles erreurs
			$form.find(".erreur").remove();
			
			// Remove de toutes les classes commencant par "has-*" et ajout des classes entrée en parametres
			$form.find(".form-group").removeClass( function (index, css) {
			    return (css.match (/(^|\s)has-\S+/g) || []).join(' ');
			}).addClass(classNames);
			
			
		},
		
		modifier : function(id){
						
			var url =  "/potager/modifier";
			this.submit(this.formModifier, url, "POST");
			
		}, 
		
		edit: function(){
			
			
			
		},
		
		supprimer : function(id){
			
			var url =  "/potager/supprimerBeanPotager";
			this.submit(this.form, url, "POST");
			
		},
		
		setFormBoutonAction : function($form, $id){
			console.log($id.val());
			
			var button = $form.find("#submitButton");
			
			if( $id.val() ){
				
				button.val("Mettre a jour");
				button.removeClass();
				button.addClass("btn btn-primary");
				$form.attr('action', pageContext + '/actions/modifier_potager');
			}
			else {
				button.val(" + Ajouter");
				button.removeClass();
				button.addClass("btn btn-success");
				$form.attr('action', pageContext + '/actions/ajouter_potager');
			}
			
		},
		
		submit: function(form, action, method){
			var url = form.attr("action") + action;
			form.attr("method", method);
			form.attr("action", url);
			
			form.submit();
		}

}



