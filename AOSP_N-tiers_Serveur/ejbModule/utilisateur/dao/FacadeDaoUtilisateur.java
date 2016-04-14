package utilisateur.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;


import utilisateur.dao.gerer.DaoGererUtilisateur;
import utilisateur.dao.lister.DaoListerUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;


@Stateless
@Local(IFacadeDaoUtilisateur.class)
public class FacadeDaoUtilisateur implements IFacadeDaoUtilisateur{
	
	
	@EJB
	private DaoGererUtilisateur daoGerer;
	
	@EJB
	private DaoListerUtilisateur daoLister;

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		daoGerer.ajouterUtilisateur(utilisateur);
		
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		daoGerer.modifierUtilisateur(utilisateur);
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		daoGerer.supprimerUtilisateur(utilisateur);
		
	}

	@Override
	public void ajouterSpecialite(Specialite specialite) {
		daoGerer.ajouterSpecialite(specialite);
		
	}

	@Override
	public void modifierSpecialite(Specialite specialite) {
		daoGerer.modifierSpecialite(specialite);
		
	}

	@Override
	public List<Utilisateur> listerUtilisateurParId() {
		
		return daoLister.listerUtilisateurParId();
	}

}
