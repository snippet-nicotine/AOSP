<%@ taglib uri="/struts-tags" prefix="s"%>
<s:form namespace="/actions" id="formulaire-ajouter" action="ajouter_potager" theme="bootstrap" cssClass="ajax form-inline" >
							
							
														
							<s:textfield
										label="Nom"
										name="potager.nom"
										tooltip="Nom du potager"
							/>
							
							<div class="form-group">
								<s:textfield
										label="Longueur"
										name="potager.longueur"
										tooltip="Longueur du potager"
								/>
								<b>X</b>
								<s:textfield
										label="Largeur"
										name="potager.largeur"
										tooltip="Largeur du potager"
								/>					
							</div>
							
							<s:textfield
									label="Code Postal"
									name="potager.codePostal"
									tooltip="Code postal (format: 13000, 65000,...)"
							/>
							
							<s:hidden name="potager.idPotager"/>
																	
							<s:submit id="submitButton" cssClass="btn btn-success" value="+ Ajouter"/>
							
						</s:form>	