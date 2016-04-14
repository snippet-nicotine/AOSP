package utilisateur.dao;

import java.util.List;

import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;

public interface IFacadeDaoUtilisateur {
	
	public void ajouterUtilisateur(Utilisateur utilisateur);
	public void modifierUtilisateur(Utilisateur utilisateur);
	public void supprimerUtilisateur(Utilisateur utilisateur);
	
	
	public void ajouterSpecialite(Specialite specialite);
	public void modifierSpecialite(Specialite specialite);
	
	
	public List<Utilisateur> listerUtilisateurParId();
	
	

}