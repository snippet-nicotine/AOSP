<%@ taglib prefix="s" uri="/struts-tags"%>


<ul id="menu">
	<li><s:a namespace="" 			action="accueil">Accueil				</s:a></li>
	
	<li><s:a namespace="/utilisateur/vue"		action="afficheDroits">CRUD droits		</s:a></li>	
		<li><s:a namespace="/utilisateur/vue"		action="afficheSpecialite">CRUD spécialité		</s:a></li>		
	
</ul>
<br />
<br />
