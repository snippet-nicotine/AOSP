package utilisateur.clientServeur;


import java.util.Collection;
import java.util.List;

import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.EtatCivil;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;


public interface IServiceUtilisateur {
	
	
	public void 			ajouterUtilisateur(Utilisateur utilisateur);
	public void 			modifierUtilisateur(Utilisateur utilisateur);
	public void 			supprimerUtilisateur(Utilisateur utilisateur);
	public Utilisateur 		rechercherParIdUtilisateur(int idUtilisateur) throws NonTrouveServiceException;	

	public void 			ajouterSpecialite(Specialite specialite);
	public void 			modifierSpecialite(Specialite specialite);
	public void 			supprimerSpecialite(Specialite specialite);
	public Specialite 		rechercherParIdSpecialite(int idSpecialite);

	public List<Specialite> getListeSpecialite();



	public void 			ajouterDroitUtilisateur(DroitUtilisateur droitUtilisateur);
	public void 			modifierDroitUtilisateur(DroitUtilisateur droitUtilisateur);
	public void 			supprimerDroitUtilisateur(DroitUtilisateur droitUtilisateur);
	public DroitUtilisateur rechercherParIdDroit(int idDroit);

	public List<DroitUtilisateur> getListeDroit();

	public List<Utilisateur> listerUtilisateurParId();


	public Utilisateur serviceFabriqueUtilisateur(TypeUtilisateur typeUtilisateur, EtatCivil etatCivil, String mail, String motPasse,
			Collection<DroitUtilisateur> droits, String codePostal, Specialite specialite);

	public Collection<DroitUtilisateur> tabToListe(String[] tab);
	public String[] 					listeToTab(Collection<DroitUtilisateur> liste);

	public void creerJeuEssai();
	

}
