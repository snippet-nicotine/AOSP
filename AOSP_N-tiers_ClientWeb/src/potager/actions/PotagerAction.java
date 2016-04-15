package potager.actions;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import commun.actions.AospAction;
import commun.config.Parametres;
import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import utilisateur.entity.Jardinier;

public class PotagerAction extends AospAction{

	protected ServiceGestionPotager serviceGestionPotager;

	
	/**
	 * Méthode qui instancie le service distant EJB
	 * @return true si tout c'est bien passé <br/>
	 *         false en cas d'erreur : Ajoute une erreur (addActionError)
	 */
	public boolean init(){
		
		boolean result = true;
		
		InitialContext initialContext;		
		
		if(serviceGestionPotager == null){
			
			try {
				initialContext = new InitialContext();
				serviceGestionPotager = (ServiceGestionPotager) initialContext.lookup( Parametres.EJB_SERVICE_GESTION_POTAGER ); 
				
			} catch (NamingException e) {
				result = false;
				addActionError("Le service distant n'a pas pu être instancié."); 
			}
		
		}
		
		return result;
		
	}
	
}
