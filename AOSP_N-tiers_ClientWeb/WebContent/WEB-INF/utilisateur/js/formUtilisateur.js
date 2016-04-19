window.onload = traitement;

function traitement(){
	var util = document.querySelector("#listeUtilisateur");
	util.onclick=function(){
		var id=util.value;
		recupererListe(id);		
	}
	document.querySelector("#idCodePostal").hidden=true;
	document.querySelector("#idSpecialite").hidden=true;


}


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
	xhr.open("GET",
			"detailUtilisateur.action?idListUtilisateur="+id,true);


	xhr.onreadystatechange = function() {
		if (xhr.readyState==4) { if (xhr.status==200)
			document.querySelector("#detail")
			.innerHTML = xhr.responseText;
		}};
		xhr.send(null);

}
