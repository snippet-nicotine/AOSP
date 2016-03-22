/*
 * 
 * Javascript pour la gestion des carrés potagers
 * 
 */
window.onload = initJsList;

function initJsList() {
	

	arrangeTableau();
	arrangeTableau2();
	
	document.getElementById("btnListTot").formAction = "/AOSP_N_tiers_Client_Web/planif/crudPlanifier/lister";
	
	document.getElementById("btnRetourGestion").addEventListener("click", function(e){
	
		e.preventDefault();
		window.location.href='/planification/html_jsp/planifier_depart.jsp';
		
	});
	

	document.querySelector("#btnList").addEventListener("click", function(){
		var ddd = document.querySelector("#monTableau").querySelectorAll("td[name=idParcelleActive]")[0].innerHTML;
		window.location.href="/AOSP_N_tiers_Client_Web/planif/crudPlanifier/lister=" + ddd;
	});
}


