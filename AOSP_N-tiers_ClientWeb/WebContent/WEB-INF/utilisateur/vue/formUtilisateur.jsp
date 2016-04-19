
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="<s:url namespace="/utilisateur/vue" action="formUtilisateurJs" />"></script>

<title>CRUD utilisateur</title>
<link rel="stylesheet"
	href="<s:url namespace="/utilisateur/vue" action="cssCommun" />" />


</head>
<body>
	<jsp:include page="../menu/menuCRUDUtilisateur.jsp" />
	<h1>CRUD utilisateur</h1>



	<s:div>
		<s:form action="affichUtilisateur" method="post">



			<s:radio id="radioType" name="type" label="Type "
				list="{'Administrateur', 'Jardinier', 'Spécialiste'}" />

			<s:textfield name="idUtilisateur" label="Id utilisateur "></s:textfield>

			<s:textfield name="nom" label="Nom "></s:textfield>
			<s:textfield name="prenom" label="prenom "></s:textfield>
			<s:textfield name="mail" label="Adresse mail "></s:textfield>
			<s:textfield name="motPasse" label="Mot de passe"></s:textfield>
			<s:select name="selectionDroit" list="lesDroits" label="Droits "
				listKey="idDroit" multiple="true" listValue="libelle" />
			<s:textfield name="codePostal" label="Code postal "></s:textfield>
			<s:select name="intSpecialite" list="lesSpecialites"
				label="Spécialité " listKey="idSpecialite" listValue="libelle" />


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

			<s:submit value="Creation" formaction="${creaUtilisateur}" />
			<s:submit value="Modification" formaction="${modifUtilisateur}" />
			<s:submit value="Suppression" formaction="${supUtilisateur}" />
			<s:submit value="Rechercher par Id" formaction="${recherUtilisateur}" />
			<s:submit value="Remplir" formaction="${remplirUtilisateur}" />

			<s:select name="idListUtilisateur" list="lesUtilisateurs"
				label="Utilisateurs par Id " listKey="idUtilisateur"
				listValue="'ID : '+idUtilisateur+', NOM : '+etatCivil.nom" size="5"
				id="listeUtilisateur" />



		</s:form>

	</s:div>
	<s:div id="detail"></s:div>

</body>
</html>