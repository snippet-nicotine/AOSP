<!-- Je n'ai volontairement pas importé les taglibs, pour éviter un import à chaque ligne du tableau 
	(tentative d'optimisation) -->

<tr 
		data-potager-id="<s:property value="idPotager"/>"
		data-potager-nom="<s:property value="nom"/>"
		data-potager-longueur="<s:property value="longueur"/>"
		data-potager-largeur="<s:property value="largeur"/>"
		data-potager-codePostal="<s:property value="codePostal"/>"
	>				

		<td> 
			<s:url namespace="/actions" action="visualiser_potager" var="visualiserPotager">
				<s:param name="id" value="idPotager"/>
			</s:url>
			<s:a href="%{visualiserPotager}" ><s:property value="nom"/></s:a>						
		</td>
		
		<td><s:property value="largeur"/> x <s:property value="largeur"/></td>
										
		<td><s:property value="codePostal"/></td>
		
		<td> <s:a href="#"><s:property value="proprietaire.nom"/></s:a></td>
		
		<td> 	
			<tags:localDate  pattern="dd/MM/yyyy" date="${dateCreation}" />
														
		</td>
	
		<td> 
			
		 </td>
		
		<td>
											
			<s:a class="bouton-afficher-modifier" href="#">
				<i class="glyphicon glyphicon-pencil"></i>									
			</s:a>
	
			<s:url namespace="/actions" action="/supprimer_potager" var="supprimerPotager">
				<s:param name="id">${idPotager}</s:param>
			</s:url>
			
			<s:a href="%{supprimerPotager}" class="">
				<i  class="glyphicon glyphicon-remove"></i>										
			</s:a>
			
		</td>
</tr>