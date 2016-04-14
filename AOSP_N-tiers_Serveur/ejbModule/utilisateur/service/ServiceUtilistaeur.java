package utilisateur.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


import utilisateur.clientServeur.IServiceUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.service.gerer.ServiceGererUtilisateur;
import utilisateur.service.lister.ServiceListerUtilisateur;


@Stateless
@Remote(IServiceUtilisateur.class)
public class ServiceUtilistaeur implements IServiceUtilisateur{

	
	@EJB
	private ServiceGererUtilisateur serviceGerer;
	@EJB
	private ServiceListerUtilisateur serviceLister;
	
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		serviceGerer.ajouterUtilisateur(utilisateur);
		
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		serviceGerer.modifierUtilisateur(utilisateur);
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		serviceGerer.supprimerUtilisateur(utilisateur);
		
	}

	@Override
	public void ajouterSpecialite(Specialite specialite) {
		serviceGerer.ajouterSpecialite(specialite);
		
	}

	@Override
	public void modifierSpecialite(Specialite specialite) {
		serviceGerer.modifierSpecialite(specialite);
		
	}

	@Override
	public List<Utilisateur> listerUtilisateurParId() {
		
		return serviceLister.listerUtilisateurParId();
	}

}
