
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- script lancé au chargement de la page-->
<script
	src="<s:url namespace="/utilisateur/vue" action="formUtilisateurJs" />"></script>

<title>CRUD utilisateur</title>

<!-- css chargée par struts -->
<link rel="stylesheet"
	href="<s:url namespace="/utilisateur/vue" action="cssCommun" />" />


</head>
<body>

	<!-- menu de la page -->
	<jsp:include page="../menu/menuCRUDUtilisateur.jsp" />

	<h1>CRUD utilisateur</h1>

	<s:div>
		<!-- Formulaire de saisie des propriétés des utilisateurs -->
		<s:form action="affichUtilisateur" method="post">
			<h2>
				<!-- message d'erreur au cas où l'utilisateur n'existe pas -->
				<s:property value="messageNonTrouve" />
			</h2>

			<!-- Radio sélectionnant le type d'utilisateur. Il réagit au click en cachant ou montrant des contrôles en fonction
du type de l'urilisateur sélectionné -->
			<s:radio name="type" label="Type "
				list="{'Administrateur', 'Jardinier', 'Spécialiste'}"
				onclick="reagirClick(value)" />

			<!-- textfields correspondant aux proprietés id, nom, prénom, mail et motPasse -->
			<s:textfield name="idUtilisateur" label="Id utilisateur "></s:textfield>
			<s:textfield name="nom" label="Nom * "></s:textfield>
			<s:textfield name="prenom" label="prenom * "></s:textfield>
			<s:textfield name="mail" label="Adresse mail * "></s:textfield>
			<s:textfield name="motPasse" label="Mot de passe * "></s:textfield>

			<!-- select contenant la liste des droits que l'on peut sélectionner (multiple) -->
			<s:select name="selectionDroit" list="lesDroits" label="Droits "
				listKey="idDroit" multiple="true" listValue="libelle" />

			<!-- textfied correspondant au codePostal -->
			<s:textfield name="codePostal" label="Code postal " id="idCodePostal"></s:textfield>

			<!-- Select contenant la liste des spécialités (pas multiple) -->
			<s:select name="intSpecialite" list="lesSpecialites"
				label="Spécialité " listKey="idSpecialite" listValue="libelle"
				id="idSpecialite" />


			<!-- actions correspondant aux boutons submit-->
			<s:url namespace="/utilisateur/vue" action="creationUtilisateur"
				var="creaUtilisateur" />
			<s:url namespace="/utilisateur/vue" action="modificationUtilisateur"
				var="modifUtilisateur" />
			<s:url namespace="/utilisateur/vue" action="suppressionUtilisateur"
				var="supUtilisateur" />
			<s:url namespace="/utilisateur/vue"
				action="rechercherParIdUtilisateur" var="recherUtilisateur" />
			<s:url namespace="/utilisateur/vue" action="remplirUtilisateur"
				var="remplirUtilisateur" />

			<!-- boutons submit CRUD -->
			<s:submit value="Creation" formaction="${creaUtilisateur}" />
			<s:submit value="Modification" formaction="${modifUtilisateur}" />
			<s:submit value="Suppression" formaction="${supUtilisateur}" />
			<s:submit value="Rechercher par Id" formaction="${recherUtilisateur}" />
			<s:submit value="Remplir" formaction="${remplirUtilisateur}" />

<!-- Liste des utilisateurs. Quand on click sur un utilisateur, les détails apparaissent grâce à AJAX -->
			<s:select name="idListUtilisateur" list="lesUtilisateurs"
				label="Utilisateurs par Id " listKey="idUtilisateur"
				listValue="'ID : '+idUtilisateur+', NOM : '+etatCivil.nom" size="5"
				id="listeUtilisateur" />
				
		</s:form>
	</s:div>
	
	<!-- Div dans lequel va s'afficher le résultat d'AJAX -->
	<s:div id="detail"></s:div>

</body>
</html>