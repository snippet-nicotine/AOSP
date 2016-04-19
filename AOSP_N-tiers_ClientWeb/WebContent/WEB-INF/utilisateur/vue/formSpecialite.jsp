<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD spécialité</title>
<link rel="stylesheet"
	href="<s:url namespace="/utilisateur/vue" action="cssCommun" />" />
</head>
<body>
	<jsp:include page="../menu/menuCRUDSpecialite.jsp" />
	<h1>CRUD spécialité</h1>

	<s:form action="affichSpecialite" method="post">

		<s:textfield name="idSpecialite" label="Id spécialité">
		</s:textfield>

		<s:textfield name="libelle" label="Libellé de la spécialité">
		</s:textfield>

		
		
		
		<s:url namespace="/utilisateur/vue" action="creationSpecialite"
			var="creaSpecialite" />
		<s:url namespace="/utilisateur/vue" action="modificationSpecialite"
			var="modifSpecialite" />
		<s:url namespace="/utilisateur/vue" action="suppressionSpecialite"
			var="supSpecialite" />
		<s:url namespace="/utilisateur/vue" action="rechercherParIdSpecialite"
			var="recherSpecialite" />
		<s:url namespace="/utilisateur/vue" action="remplirSpecialite"
			var="remplirSpecialite" />

		<s:submit value="Creation" formaction="${creaSpecialite}" />
		<s:submit value="Modification" formaction="${modifSpecialite}" />
		<s:submit value="Suppression" formaction="${supSpecialite}" />
		<s:submit value="Rechercher par Id" formaction="${recherSpecialite}" />
		<s:submit value="Remplir" formaction="${remplirSpecialite}" />
	</s:form>
</body>
</html>