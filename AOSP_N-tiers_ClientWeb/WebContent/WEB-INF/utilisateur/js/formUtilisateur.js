window.onload = traitement;

function traitement(){

	// on affect une fonction au click sur un élément de la liste utilisateur
	var util = document.querySelector("#listeUtilisateur");
	util.onclick=function(){
		var id=util.value;

		// on appelle la fonction qui fait une requete AJAX
		recupererListe(id);	
	}

	// on affiche les contrôles qui correspondent au type d'utilisateur	
	reagirClick(document.querySelector("#idUtil").value);


}

/**
 * fonction qui cache ou affiche le code postal ou la liste des spécialité, en fonction du bouton radio sélectionné
 */
function reagirClick(value){
	if(value=="Administrateur"){
		document.querySelector("#idCodePostal").hidden=true;		
		document.querySelector("#idSpecialite").hidden=true;
	}
	if(value=="Jardinier"){
		document.querySelector("#idCodePostal").hidden=false;
		document.querySelector("#idSpecialite").hidden=true;		
	}
	if(value=="Spécialiste"){
		document.querySelector("#idCodePostal").hidden=false;
		document.querySelector("#idSpecialite").hidden=false;		
	}
}


/**
 * Fonction qui exécute une requête AJAX
 * @param id
 */
function recupererListe(id){
	var xhr=null;
	if (window.XMLHttpRequest) xhr = new XMLHttpRequest();
	else if (window.ActiveXObject) {
		try { 
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");

		}
	}

	// on passe en GET puisque l'on ne change pas la base de données
	xhr.open("GET",
			"detailUtilisateur.action?idListUtilisateur="+id,true);

	// on affecte le comportement du XMLHttpRequest. Si la requête est terminée (4) et qu'elle s'est bien passée (200)
	// on détermine l'objet de la page qui recevra la réponse de la requête.
	xhr.onreadystatechange = function() {
		if (xhr.readyState==4) { if (xhr.status==200)
			document.querySelector("#detail")
			.innerHTML = xhr.responseText;
		}};

		// on envoi la requête
		xhr.send(null);

}
