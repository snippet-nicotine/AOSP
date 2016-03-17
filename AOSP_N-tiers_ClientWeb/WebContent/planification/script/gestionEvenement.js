/*
 * 
 * Javascript pour la gestion des évènements
 * 
 *
 */

window.onload = initJs;

function initJs() {
	arrangeTableau();
	arrangeTableau2();
//	alert("debut2");
//	document.getElementById("btnCreer").formAction = "./ServletAddCarre";
	document.getElementById("btnCreer").onclick=function(){
//		alert("avant btncreer");
		if (!controlChamps()) {
			return false;
		} else {
			document.getElementById("btnCreer").formMethod = "post";
			document.getElementById("btnCreer").formAction = "/AOSP_N-tiers_ClientWeb/planif/crudPlanifier/creer";
//			alert(document.getElementById("btnCreer").formAction);
			document.getElementById("btnCreer").formNoValidate= true;
		}
	};

	document.getElementById("btnModif").onclick=function(){
//		alert("avant btnmodifier yoyoyoyoyoyoyyoyoyoy");
		if (!controlChamps()) {
			return false;
		} else {
			document.getElementById("btnModif").formMethod = "post";
			document.getElementById("btnModif").formAction = "/AOSP_N_tiers_Client_Web/planif/crudPlanifier/modifier";
			document.getElementById("btnModif").formNoValidate= true;
		}
	};

	document.getElementById("btnSup").onclick=function(){
		var temp = "Etes-vous sur de vouloir annuler cet évènement ?"
			if (confirm(temp))
			{
				document.getElementById("btnSup").formMethod = "post";
				document.getElementById("btnSup").formAction = "/AOSP_N_tiers_Client_Web/planif/crudPlanifier/supprimer";
				document.getElementById("btnSup").formNoValidate= true;
			}
	};

	document.getElementById("btnQuit").addEventListener("click", function(e){
		e.preventDefault();
		window.location.href=request.getContextPath() + "/planification/html_jsp/planifier_depart.jsp";
	});

//	alert("ccccc");

	// traitement de btnList qui appelle la servlet ServletListCarreDeParcelle 
	// en transmettant les valeurs de la ligne de la table selectionnees
	// document.querySelector("#monTableau").querySelectorAll("td[name=idParcelleActive]")[0].innerHTML
	// récupère l'id de la parcelle active qui est sur la ligne sélectionnée du tableau monTableau
	document.querySelector("#btnList").addEventListener("click", function(e){
		e.preventDefault();
//		alert("toto");
		var ddd = document.querySelector("#monTableau").querySelectorAll("td[name=idPlanningActive]")[0].innerHTML;
		// Passage en paramètre de l'id de la parcelle active	
//		alert(ddd);
		window.location.href="./planif/listerPlanifier/lister?idPlanningActive=" + ddd;
//		alert(ddd);
	});

}

/**
 * controlChamps est lancée avant d'invoquer une servlet
 */
function controlChamps() {

	var isOk = true;
	var leMessage ="";
	// Pour la vérification d'un entier strictement positif
	var maRegExVerifEntierPositif = new RegExp("^[1-9]+$|^[1-9]+[0-9]*$");
	var maRegExVerifDate = new RegExp("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");

	var s_idEvenement = document.getElementById("idEvenement").value;
	if (maRegExVerifEntierPositif.exec(s_idEvenement) == null){
		leMessage += "\nL'id de l'évènement n'est pas un entier correcte";
		isOk = false;
	}
//	alert("debut ctrl2");
	var s_idPlanning = document.getElementById("idPlanning").value;
	if (maRegExVerifEntierPositif.exec(s_idPlanning) == null){
		leMessage += "\nL'id du planning n'est pas un entier correcte";
		isOk = false;
	}

	var s_idAction = document.getElementById("idAction").value;
	if (maRegExVerifEntierPositif.exec(s_idAction) == null){
		leMessage += "\nL'id de l'action n'est pas un entier correcte";
		isOk = false;
	}

	var s_idPlante = document.getElementById("idPlante").value;
	if (maRegExVerifEntierPositif.exec(s_idPlante) == null){
		leMessage += "\nL'id de la plante n'est pas un entier correcte";
		isOk = false;
	}

//	var dateEvenement = document.getElementById("dateEvenement").value;
//	if (maRegExVerifDate.exec(dateEvenement) == null){
//	leMessage += "\nLa date de l'évènement n'est pas correcte";
//	isOk = false;
//	}

	if (leMessage != "") {
		alert(leMessage);
	}
	return isOk;
}

/**
 * verifEntierPositifNonNul est appelée à la fin de la saisie d'un champ
 * contenant un entier : active un fond rouge si la saisie est incorrecte
 * @param elem
 */
function verifEntierPositifNonNul(elem) {
	var maRegExVerifEntierPositif = new RegExp("^[1-9]+$|^[1-9]+[0-9]*$");
	if (maRegExVerifEntierPositif.exec(elem.value) == null){
		elem.style.backgroundColor = "#FA8072";
	}else{
		elem.style.backgroundColor = "#FFFFFF";
	}
}

/**
 * verifAlphanumerique est appelée à la fin de la saisie d'un champ
 * contenant une chaine de caractère alphanumérique et
 * active un fond rouge si la saisie est incorrecte
 * @param elem
 */
function verifAlphanumerique(elem) {
	var maRegExVerifEntierPositif = new RegExp("^[a-zA-Z0-9]$");
	if (maRegExVerifEntierPositif.exec(elem.value) == null){
		elem.style.backgroundColor = "#FA8072";
	}else{
		elem.style.backgroundColor = "#FFFFFF";
	}
}

//function verifDate(elem) {
//var maRegExControlDate = new RegExp("^[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}$","g");
//if (maRegExControlDate.test(elem.value) == false){
//elem.style.backgroundColor = "#FA8072";
//}else{
//elem.style.backgroundColor = "#FFFFFF";
//}
//}

/**
 * isDate est appelée à la fin de la saisie d'un champ
 * contenant une datee et
 * active un fond rouge si la saisie est incorrecte
 * @param elem
 */
function isDate(elem){
	var maRegExVerifDate = new RegExp("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
//	alert(elem);
	if ((!elem.value == null) || (!elem.value == "") || (!elem.value == " ")) {
		if (maRegExVerifDate.exec(elem.value) == null){
			elem.style.backgroundColor = "#FA8072";
		}else{
			elem.style.backgroundColor = "#FFFFFF";
		}
	}
	return false;
//	var arDate = sDate.split(sSeparator);
//	var iDay = parseInt(arDate[0]);
//	var iMonth = parseInt(arDate[1]);
//	var iYear = parseInt(arDate[2]);
//	var arDayPerMonth = [31,(isLeapYear(iYear))?29:28,31,30,31,30,31,31,30,31,30,31];
//	if(!arDayPerMonth[iMonth-1]){
//	elem.style.backgroundColor = "#FA8072";
//	return false;
//	}
//	return (iDay <= arDayPerMonth[iMonth-1] && iDay > 0);
}

/**
 * vive les année bisextiles
 */
function isLeapYear(iYear){
	return ((iYear%4==0 && iYear%100!=0) || iYear%400==0);
}




