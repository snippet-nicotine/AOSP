/**
 * Changement d'état et travail sur les deux tableaux parcelles et carres potagers
 */

var element_selectionne_planning;
var id_element_selectionne_planning;

var element_selectionne_evenement;
var id_element_selectionne_evenement;


/**
 * Activation d'une ligne du tableau des planning
 * @param elem : ligne sélectionnée
 * @param i : index de cette ligne
 */
function selectionne_planning(elem, i) {
//	alert("dans tableau2222222 dddddddddddddddddd");
//	alert("dans selectionne_planning");
	// on met la couleur standard de fond des lignes
	if(element_selectionne_planning){ // si n'existe pas : premier passage
		// permet de supprimer la couleur d'une ligne sélectionnée, s'il y en a une
		if(id_element_selectionne_planning % 2 == 0)//si la clé est impaire
		{
			element_selectionne_planning.style.backgroundColor = "#a0cfcf";
		}
		else //elle est paire
		{
			element_selectionne_planning.style.backgroundColor = "#6fb7b7";
		}
		// on vide la valeur de name de l'ancienne ligne planning active
		var ff = id_element_selectionne_planning.toString();
		document.getElementById("tdidPlanning"+ ff ).setAttribute("name","");
	}
	
	if(element_selectionne_evenement){ // si n'existe pas : premier passage
		// permet de supprimer la couleur d'une ligne sélectionnée, s'il y en a une
		if(id_element_selectionne_evenement % 2 == 0)//si la clé est impaire
		{
			element_selectionne_evenement.style.backgroundColor = "#a0cfcf";
		}
		else //elle est paire
		{
			element_selectionne_evenement.style.backgroundColor = "#6fb7b7";
		}
	}
	// couleur de la ligne active
	elem.style.backgroundColor = "#aeffd7";
	// affectation de la nouvelle ligne planning active
	element_selectionne_planning = elem;
	// affectation du nouveau numéro de ligne active (planning active)
	id_element_selectionne_planning = i;
	
	// récupération dans dd de la chaine de caractère correspondant au numéro de la ligne active
	var dd = id_element_selectionne_planning.toString();
	// Modification du name de la ligne active : name = "idPlanningActive"
	document.getElementById("tdidPlanning"+dd).setAttribute("name","idPlanningActive");
	
	// Les 2 champs de saisie "nomPlanning" et "idPlanning" sont renseignés par la ligne sélectionnée du tableau
	document.getElementById("nomPlanning").value = document.getElementById("monTableau").rows[i].cells.item(1).innerHTML;
	document.getElementById("idPlanning").value = document.getElementById("monTableau").rows[i].cells.item(0).innerHTML;
	// Si besoin, on met le reste à vide
	document.getElementById("idEvenement").value 	= "";
	document.getElementById("idPlanning").value 	= "";
	document.getElementById("idAction").value 		= "";
	document.getElementById("idPlante").value 		= "";
	document.getElementById("idNutrition").value 	= "";
	document.getElementById("dateEvenement").value 	= "";
	document.getElementById("comAuto").value 		= "";
	document.getElementById("com").value 			= "";

	
	document.getElementById("idEvenement").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("idPlanning").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("idAction").style.backgroundColor 		= "#FFFFFF";
	document.getElementById("idPlante").style.backgroundColor 		= "#FFFFFF";
	document.getElementById("idNutrition").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("dateEvenement").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("comAuto").style.backgroundColor 		= "#FFFFFF";
	document.getElementById("com").style.backgroundColor 			= "#FFFFFF";
}

/**
 * Activation d'une ligne du tableau des evenements
 * @param elem : ligne sélectionnée
 * @param i : id de l'évènement
 * @param j : index de la ligne sélectionnée
 */
function selectionne_evenement(elem, i,j ) {
	// on met la couleur standard de fond des lignes
	if(element_selectionne_evenement){ // si n'existe pas : premier passage
		// permet de supprimer la couleur d'une ligne sélectionnée, s'il y en a une
		if(id_element_selectionne_evenement % 2 == 0)//si la clé est impaire
		{
			element_selectionne_evenement.style.backgroundColor = "#a0cfcf";
		}
		else //elle est paire
		{
			element_selectionne_evenement.style.backgroundColor = "#6fb7b7";
		}
	}
	
	if(element_selectionne_planning){ // si n'existe pas : premier passage
		// permet de supprimer la couleur d'une ligne sélectionnée, s'il y en a une
		if(id_element_selectionne_planning % 2 == 0)//si la clé est impaire
		{
			element_selectionne_planning.style.backgroundColor = "#a0cfcf";
		}
		else //elle est paire
		{
			element_selectionne_planning.style.backgroundColor = "#6fb7b7";
		}
	}
	// couleur de la ligne active
	elem.style.backgroundColor = "#aeffd7";
	// affectation de la nouvelle ligne active d'évènement 
	element_selectionne_evenement = elem;
	// affectation du nouveau numéro de ligne active (evenement ligne active)
	id_element_selectionne_evenement = j;
	
	// pour rechercher le name de la ligne sélectionnée
	var lignedd = "monEvenement" + j;
	
	// on rempli les champs de saisie du bas
	document.getElementById("idEvenement").value = i;
	document.getElementById("idPlanning").value 	= document.getElementById("monTableauPotager").rows[lignedd].cells.item(1).innerHTML;
	document.getElementById("idAction").value 		= document.getElementById("monTableauPotager").rows[lignedd].cells.item(2).innerHTML;
	document.getElementById("idPlante").value 		= document.getElementById("monTableauPotager").rows[lignedd].cells.item(3).innerHTML;
	document.getElementById("idNutrition").value 	= document.getElementById("monTableauPotager").rows[lignedd].cells.item(4).innerHTML;
	document.getElementById("dateEvenement").value 	= document.getElementById("monTableauPotager").rows[lignedd].cells.item(7).innerHTML;
	document.getElementById("comAuto").value 		= document.getElementById("monTableauPotager").rows[lignedd].cells.item(8).innerHTML;
	document.getElementById("com").value 			= document.getElementById("monTableauPotager").rows[lignedd].cells.item(9).innerHTML;
	
	document.getElementById("idEvenement").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("idPlanning").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("idAction").style.backgroundColor 		= "#FFFFFF";
	document.getElementById("idPlante").style.backgroundColor 		= "#FFFFFF";
	document.getElementById("idNutrition").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("dateEvenement").style.backgroundColor 	= "#FFFFFF";
	document.getElementById("comAuto").style.backgroundColor 		= "#FFFFFF";
	document.getElementById("com").style.backgroundColor 			= "#FFFFFF";
}

/**
 * Activation d'une ligne du tableau des plannings de la fenêtre des listes des évènements
 * @param elem : ligne sélectionnée
 * @param i : index de cette ligne
 * Cette fonction ressemble à selectionne_planning utilisé pour la gestion des évènements
 * le changement : pas d'affectation des champs du bas : car il n'y en a pas dans cette fenetre 
 */
function selectionne_planning2(elem, i) {
	// on met la couleur standard de fond des lignes
	if(element_selectionne_planning){ // si n'existe pas : premier passage
		// permet de supprimer la couleur d'une ligne sélectionnée, s'il y en a une
		if(id_element_selectionne_planning % 2 == 0)//si la clé est impaire
		{
			element_selectionne_planning.style.backgroundColor = "#a0cfcf";
		}
		else //elle est paire
		{
			element_selectionne_planning.style.backgroundColor = "#6fb7b7";
		}
		
		// on vide la valeur de name de l'ancienne ligne planning active
		var ff = id_element_selectionne_planning.toString();
		document.getElementById("tdidPlanning"+ ff ).setAttribute("name","");
	}
	
	if(element_selectionne_evenement){ // si n'existe pas : premier passage
		// permet de supprimer la couleur d'une ligne sélectionnée, s'il y en a une
		if(id_element_selectionne_evenement % 2 == 0)//si la clé est impaire
		{
			element_selectionne_evenement.style.backgroundColor = "#a0cfcf";
		}
		else //elle est paire
		{
			element_selectionne_evenement.style.backgroundColor = "#6fb7b7";
		}
	}
	// couleur de la ligne active
	elem.style.backgroundColor = "#aeffd7";
	// affectation de la nouvelle ligne planning active
	element_selectionne_planning = elem;
	// affectation du nouveau numéro de ligne active (planning active)
	id_element_selectionne_planning = i;
	// récupération dans dd de la chaine de caractère correspondant au numéro de la ligne active
	var dd = id_element_selectionne_planning.toString();
	// Modification du name de la ligne active : name = "idPlanningActive"
	document.getElementById("tdidPlanning"+dd).setAttribute("name","idPlanningActive");
	// mise en parametre du numero de l'id du planning
	request.setParameter("idPlanningActive", document.getElementById("monTableau").rows[i].cells.item(0).innerHTML);
}




function afficheInfo(ligne, id) {

	var arrayLignes = document.getElementById("monTableauPotager").rows; //l'array est stocké dans une variable
	var longueur = arrayLignes.length;//on peut donc appliquer la propriété length


	var numero = ligne.rowIndex;
//	alert(numero);
	var laLigne = arrayLignes[numero-1];
//    alert(laLigne);
	
	document.getElementById("nomPlanning").value = id;
	
//	var laValeur = laLigne.getElementById("Id").value;
//	alert(laValeur);
	var dd = arrayLignes[numero].HTMLTableCellElement;
}

/**
 * Lancée au chargement de la fenêtre
 * met les couleurs de fond du tableau des plannings
 */
function arrangeTableau() {
	var arrayLignes = document.getElementById("monTableau").rows; //l'array est stocké dans une variable
	var longueur = arrayLignes.length;//on peut donc appliquer la propriété length
	var i=0; //on définit un incrémenteur qui représentera la clé

	while(i<longueur)
	{
		if(i % 2 == 0)//si la clé est paire
		{
			arrayLignes[i].style.backgroundColor = "#a0cfcf";
		}
		else //elle est impaire
		{
			arrayLignes[i].style.backgroundColor = "#6fb7b7";
		}
		i++;
	}
}

/**
 * Lancée au chargement de la fenêtre
 * met les couleurs de fond du tableau des carres potager
 */
function arrangeTableau2() {
//	alert("dans tableau2222222");
	var arrayLignes = document.getElementById("monTableauPotager").rows; //l'array est stocké dans une variable
	var longueur = arrayLignes.length;//on peut donc appliquer la propriété length
	var i=0; //on définit un incrémenteur qui représentera la clé

	while(i<longueur)
	{
		if(i % 2 == 0)//si la clé est paire
		{
			arrayLignes[i].style.backgroundColor = "#a0cfcf";
		}
		else //elle est impaire
		{
			arrayLignes[i].style.backgroundColor = "#6fb7b7";
		}
		i++;
	}
}

/**
 * remise à vide des champs de saisie du bas de la fenêtre
 */
function clearChamps() {
	
	document.getElementById("idEvenement").value = "";
	document.getElementById("idPlanning").value = "";
	document.getElementById("idAction").value = "";
	document.getElementById("idPlante").value = "";
	document.getElementById("idNutrition").value = "";
	document.getElementById("dateEvenement").value = "";
	document.getElementById("comAuto").value = "";
	document.getElementById("com").value = "";
	
	document.getElementById("idEvenement").style.backgroundColor = "#FFFFFF";
	document.getElementById("idPlanning").style.backgroundColor = "#FFFFFF";
	document.getElementById("idAction").style.backgroundColor = "#FFFFFF";
	document.getElementById("idPlante").style.backgroundColor = "#FFFFFF";
	document.getElementById("idNutrition").style.backgroundColor = "#FFFFFF";
	document.getElementById("dateEvenement").style.backgroundColor = "#FFFFFF";
	document.getElementById("comAuto").style.backgroundColor = "#FFFFFF";
	document.getElementById("com").style.backgroundColor = "#FFFFFF";
	
}


//function numeroLigne(ligne)
//{
//	var numero = ligne.rowIndex;
//	ligne.cells[0].innerHTML = numero+1;
//}
//
//function ajouterLigne()
//{
//	var tableau = document.getElementById("monTableau");
//
//	var ligne = tableau.insertRow(-1);//on a ajouté une ligne
//
//	var colonne1 = ligne.insertCell(0);//on a une ajouté une cellule
//	colonne1.innerHTML += document.getElementById("Id").value;//on y met le contenu d'id
//
//	var colonne2 = ligne.insertCell(1);//on ajoute la seconde cellule
//	colonne2.innerHTML += document.getElementById("Nom").value;
//
//	var date = new Date();
//	var colonne3 = ligne.insertCell(2);
//	colonne3.innerHTML += date.getDate();//on ajoute le jour du mois
//
//	var colonne4 = ligne.insertCell(3);
//	colonne4.innerHTML += date.getMonth()+1;//les mois commencent par 0
//
//	var colonne5 = ligne.insertCell(4);
//	colonne5.innerHTML += date.getFullYear();
//}
//
//function supprimerLigne(num)
//{
//	document.getElementById("monTableau").deleteRow(num);
//}