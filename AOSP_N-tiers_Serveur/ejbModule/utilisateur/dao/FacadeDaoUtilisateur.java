package utilisateur.dao;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;


import utilisateur.dao.gerer.DaoGererUtilisateur;
import utilisateur.dao.jeuEssai.DaoJeuEssai;
import utilisateur.dao.lister.DaoListerUtilisateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.exception.NonTrouveDAOException;


@Stateless
@Local(IFacadeDaoUtilisateur.class)
public class FacadeDaoUtilisateur implements IFacadeDaoUtilisateur{
	
	
	@EJB
	private DaoGererUtilisateur daoGerer;
	
	@EJB
	private DaoListerUtilisateur daoLister;
	
	@EJB
	private DaoJeuEssai daoJeuEssai;

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
	public Utilisateur rechercherParIdUtilisateur(int idUtilisateur) throws NonTrouveDAOException{
		return daoGerer.rechercherParIdUtilisateur(idUtilisateur);
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
	public void supprimerSpecialite(Specialite specialite){
		daoGerer.supprimerSpecialite(specialite);
	}

	@Override
	public Specialite rechercherParIdSpecialite(int idSpecialite){
		return daoGerer.rechercherParIdSpecialite(idSpecialite);
		
	}
	
	@Override
	public List<Specialite> getListeSpecialite() {
		
		return daoLister.getListeSpecialite();
	}
	
	
	@Override
	public void ajouterDroitUtilisateur(DroitUtilisateur droitUtilisateur) {
		daoGerer.ajouterDroitUtilisateur(droitUtilisateur);
		
	}

	@Override
	public void modifierDroitUtilisateur(DroitUtilisateur droitUtilisateur) {
		daoGerer.modifierDroitUtilisateur(droitUtilisateur);
		
	}

	@Override
	public void supprimerDroitUtilisateur(DroitUtilisateur droitUtilisateur) {
		daoGerer.supprimerDroitUtilisateur(droitUtilisateur);
		
	}
	
	@Override
	public DroitUtilisateur rechercherParIdDroit(int idDroit){
		return daoGerer.rechercherParIdDroit(idDroit);
	}
	
	public List<DroitUtilisateur> getListeDroit(){
		return daoLister.getListeDroit();
	}
	
	
	
	
	@Override
	public List<Utilisateur> listerUtilisateurParId() {
		
		return daoLister.listerUtilisateurParId();
	}

	@Override
	public void creerJeuEssai(){
		daoJeuEssai.creerJeuEssai();
	}

}
