package potager.actions;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import commun.actions.AospAction;
import commun.config.Parametres;
import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DaoPotagerAjoutException;
import potager.service.exception.DaoPotagerQueryException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

public class GestionPotager extends AospAction{

	private static final long serialVersionUID = 1L;
	
	private ServiceGestionPotager serviceGestionPotager;
	private ArrayList<Potager> potagers;
	private Potager potager;
	
	/**
	 * Méthode qui instancie le service distant EJB
	 * @return true si tout c'est bien passé <br/>
	 *         false en cas d'erreur : Ajoute une erreur (addActionError)
	 */
	public boolean init(){
		
		boolean result = true;
		InitialContext initialContext;
		potagers = new ArrayList<Potager>();
		
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
	
	public String execute(){		
		
		return lister();
		
	}
	
	public String lister(){
		
		System.out.println("LISTING");
		String result = SUCCESS;
				
		if( !init() ){
			result = ERROR;	
		}
		
		else{
			
			try {
				potagers = (ArrayList<Potager>) serviceGestionPotager.listerPotager();
				System.out.println(potagers);
				
			} catch (DaoPotagerQueryException e) {				
				addActionError( e.getMessage() );
			}
		}
		
		return result;
	}
	
	public String ajouter(){
		
		
		String result = SUCCESS;
		
		if( !init() ){
			result = ERROR;
		} 
		else {
			
			try {
				Jardinier user = new Jardinier();
				user.setNom("nico");
				potager.setProprietaire( user );
				serviceGestionPotager.ajouterPotager(potager);
				
			} catch (NomPotagerException e) {		
				addFieldError("potager.nom", e.getMessage() );
			} catch (CPPotagerException e) {		
				addFieldError("potager.codePostal", e.getMessage() );
			} catch (ProprietairePotagerException e) {
				addFieldError("potager.proprietaire", e.getMessage() );
			} catch (DimensionPotagerException e) {
				addFieldError("potager.longueur", e.getMessage() );
				addFieldError("potager.largeur", e.getMessage() );
			} catch (DaoPotagerAjoutException e) {
				addActionError( e.getMessage() );
			}
			
		}
		
		return SUCCESS;
	}
	
	public ArrayList<Potager> getPotagers() {
		return potagers;
	}
	public void setPotagers(ArrayList<Potager> potagers) {
		this.potagers = potagers;
	}
	public Potager getPotager() {
		return potager;
	}
	public void setPotager(Potager potager) {
		this.potager = potager;
	}

	public int getNombreAnnulations() {
		return serviceGestionPotager.getNombreAnnulations();
	}	

}
