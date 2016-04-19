package utilisateur.dao;

import java.util.List;

import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.exception.NonTrouveDAOException;

public interface IFacadeDaoUtilisateur {
	
	public void ajouterUtilisateur(Utilisateur utilisateur);
	public void modifierUtilisateur(Utilisateur utilisateur);
	public void supprimerUtilisateur(Utilisateur utilisateur);	
	public Utilisateur rechercherParIdUtilisateur(int idUtilisateur) throws NonTrouveDAOException;
	
	
	public void ajouterSpecialite(Specialite specialite);
	public void modifierSpecialite(Specialite specialite);
	public void supprimerSpecialite(Specialite specialite);
	public Specialite rechercherParIdSpecialite(int idSpecialite);
	
	public List<Specialite> getListeSpecialite();
	
	
	
	public void ajouterDroitUtilisateur(DroitUtilisateur droitUtilisateur);
	public void modifierDroitUtilisateur(DroitUtilisateur droitUtilisateur);
	public void supprimerDroitUtilisateur(DroitUtilisateur droitUtilisateur);
	public DroitUtilisateur rechercherParIdDroit(int idDroit);
	
	public List<DroitUtilisateur> getListeDroit();
	
	public List<Utilisateur> listerUtilisateurParId();
	
	

}
