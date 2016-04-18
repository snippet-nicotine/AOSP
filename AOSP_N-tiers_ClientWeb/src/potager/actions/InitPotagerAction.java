package potager.actions;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import commun.actions.GestionAction;
import commun.config.Parametres;
import potager.clientServeur.ServiceGestionPotager;

/**
 * Classe permettant d'initialiser l'accès au service distant (EJB)
 * Le but de cette classe est de mutualiser le code propre à tous les BeanAction traitant du concepte de Potager
 * @author Nicolas LAMBERT
 *
 */
public class InitPotagerAction extends GestionAction {

	protected ServiceGestionPotager serviceGestionPotager;
	
	/**
	 * Méthode qui instancie le service distant EJB
	 * @return true si tout c'est bien passé <br/>
	 *         false en cas d'erreur : Ajoute une erreur (addActionError)
	 */
	@Override
	protected boolean init() {
		
		boolean result = true;
		
		InitialContext initialContext;		
		
		if(serviceGestionPotager == null){
			
			try {
				
				initialContext = new InitialContext();
				serviceGestionPotager = (ServiceGestionPotager) initialContext.lookup( Parametres.EJB_SERVICE_GESTION_POTAGER );				
				
			} catch (NamingException e) {
				result = false;
				addActionError( getText("erreur.service") ); 
			}
		
		}
		
		return result;
	}

}
