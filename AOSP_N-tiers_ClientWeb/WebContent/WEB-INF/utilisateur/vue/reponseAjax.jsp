<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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