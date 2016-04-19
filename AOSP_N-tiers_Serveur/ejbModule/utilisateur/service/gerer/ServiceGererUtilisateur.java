package utilisateur.service.gerer;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.clientServeur.NonTrouveServiceException;
import utilisateur.dao.IFacadeDaoUtilisateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.exception.NonTrouveDAOException;


@Stateless
@LocalBean
public class ServiceGererUtilisateur {
	
	@EJB
	IFacadeDaoUtilisateur daoGerer;
	
	public void ajouterUtilisateur(Utilisateur utilisateur){
		daoGerer.ajouterUtilisateur(utilisateur);
	}
	
	public void modifierUtilisateur(Utilisateur utilisateur){
		daoGerer.modifierUtilisateur(utilisateur);
	}
	
	public void supprimerUtilisateur(Utilisateur utilisateur){
		daoGerer.supprimerUtilisateur(utilisateur);
	}
	
	public Utilisateur rechercherParIdUtilisateur(int idUtilisateur) throws NonTrouveServiceException{
		Utilisateur utilisateur=null;
		try {
			utilisateur= daoGerer.rechercherParIdUtilisateur(idUtilisateur);
		} catch (NonTrouveDAOException e) {
			// on envoi un message compréhensible par l'utilisateur
			throw new NonTrouveServiceException("L'utilisateur n'existe pas ! Opération annulée.");
		}
		return utilisateur;
	}

	
	public void ajouterSpecialite(Specialite specialite){
		daoGerer.ajouterSpecialite(specialite);
	}
	public void modifierSpecialite(Specialite specialite){
		daoGerer.modifierSpecialite(specialite);
	}
	
	public void supprimerSpecialite(Specialite specialite){
		daoGerer.supprimerSpecialite(specialite);
	}
	
	public Specialite rechercherParIdSpecialite(int idSpecialite){
		return daoGerer.rechercherParIdSpecialite(idSpecialite);
	}
	
	
	public void ajouterDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		daoGerer.ajouterDroitUtilisateur(droitUtilisateur);
	}
	
	public void modifierDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		daoGerer.modifierDroitUtilisateur(droitUtilisateur);
	}
	
	public void supprimerDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		daoGerer.supprimerDroitUtilisateur(droitUtilisateur);
	}
	
	public DroitUtilisateur rechercherParIdDroit(int idDroit){
		return daoGerer.rechercherParIdDroit(idDroit);
	}
	
	
	

}
