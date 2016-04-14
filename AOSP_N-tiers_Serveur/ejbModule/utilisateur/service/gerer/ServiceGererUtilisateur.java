package utilisateur.service.gerer;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.dao.IFacadeDaoUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;


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
	
	public void ajouterSpecialite(Specialite specialite){
		daoGerer.ajouterSpecialite(specialite);
	}
	public void modifierSpecialite(Specialite specialite){
		daoGerer.modifierSpecialite(specialite);
	}
	

}
