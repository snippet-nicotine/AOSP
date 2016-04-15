<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD droits</title>
<link rel="stylesheet"
	href="<s:url namespace="/utilisateur/vue" action="cssCommun" />" />
</head>
<body>
<jsp:include page="../menu/menuCRUDDroits.jsp" />
<h1>CRUD droits</h1>

<s:form action="affichDroits" method="post">
		<s:url namespace="/utilisateur/vue" action="creationDroits"
			var="creaDroits" />
		<s:url namespace="/utilisateur/vue" action="modificationDroits"
			var="modifDroits" />
		<s:url namespace="/utilisateur/vue" action="suppressionDroits"
			var="supDroits" />
		<s:url namespace="/utilisateur/vue"
			action="rechercherParIdDroits" var="recherDroits" />
		<s:url namespace="/utilisateur/vue" action="remplirDroits"
			var="remplirDroits" />

		<s:submit value="Creation" formaction="${creaDroits}" />
		<s:submit value="Modification" formaction="${modifDroits}" />
		<s:submit value="Suppression" formaction="${supDroits}" />
		<s:submit value="Rechercher par Id" formaction="${recherDroits}" />
		<s:submit value="Remplir" formaction="${remplirDroits}" />
	</s:form>
</body>
</html>