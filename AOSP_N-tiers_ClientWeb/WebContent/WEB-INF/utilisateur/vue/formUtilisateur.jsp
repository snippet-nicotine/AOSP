<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>CRUD utilisateur</title>
<link rel="stylesheet"
	href="<s:url namespace="/utilisateur/vue" action="cssCommun" />" />
</head>
<body>
	<jsp:include page="../menu/menuCRUDUtilisateur.jsp" />
	<h1>CRUD utilisateur</h1>


	<s:form action="affichUtilisateur" method="post">
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
	</s:form>

</body>
</html>