<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>AJAX</h1>

	<s:label
		name="'PRENOM : '+utilisateurSelectionne.etatCivil.prenom
+', MAIL : '+utilisateurSelectionne.mail+', MOT DE PASSE : '+utilisateurSelectionne.motPasse+', DROITS : '"></s:label>

	<s:iterator value="lesDroitsSelectionnes">
		<s:property value="libelle+', '" />
	</s:iterator>


</body>
</html>