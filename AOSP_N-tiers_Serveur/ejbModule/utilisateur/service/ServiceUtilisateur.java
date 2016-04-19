package utilisateur.service;


import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import utilisateur.clientServeur.IServiceUtilisateur;
import utilisateur.clientServeur.NonTrouveServiceException;
import utilisateur.clientServeur.TypeUtilisateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.EtatCivil;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.fabrique.FabriqueUtilisateur;
import utilisateur.service.gerer.ServiceGererUtilisateur;
import utilisateur.service.lister.ServiceListerUtilisateur;


@Stateless
@Remote(IServiceUtilisateur.class)
public class ServiceUtilisateur implements IServiceUtilisateur{

	
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
	public Utilisateur rechercherParIdUtilisateur(int idUtilisateur) throws NonTrouveServiceException{
		return serviceGerer.rechercherParIdUtilisateur(idUtilisateur);
	}

	
	@Override
	public Collection<DroitUtilisateur> tabToListe(String[] tab){
		return serviceLister.tabToListe(tab);
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
	public void supprimerSpecialite(Specialite specialite){
		serviceGerer.supprimerSpecialite(specialite);
	}
	
	@Override
	public Specialite rechercherParIdSpecialite(int idSpecialite){
		return serviceGerer.rechercherParIdSpecialite(idSpecialite);
	}
	
	
	@Override
	public List<Specialite> getListeSpecialite(){
		return serviceLister.getListeSpecialite();
	}
	
	@Override
	public void ajouterDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		serviceGerer.ajouterDroitUtilisateur(droitUtilisateur);
	}
	
	@Override
	public void modifierDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		serviceGerer.modifierDroitUtilisateur(droitUtilisateur);
	}
	
	@Override
	public void supprimerDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		serviceGerer.supprimerDroitUtilisateur(droitUtilisateur);
	}
	
	@Override
	public DroitUtilisateur rechercherParIdDroit(int idDroit){
		return serviceGerer.rechercherParIdDroit(idDroit);
	}
	
	@Override
	public List<DroitUtilisateur> getListeDroit(){
		return serviceLister.getListeDroit();
	}
	
	public Utilisateur serviceFabriqueUtilisateur(TypeUtilisateur typeUtilisateur, EtatCivil etatCivil, String mail, String motPasse,
			Collection<DroitUtilisateur> droits, String codePostal, Specialite specialite){
		return FabriqueUtilisateur.fabriqueUtilisateur(typeUtilisateur, etatCivil, mail, motPasse, droits, codePostal,
				specialite);
	}

	@Override
	public List<Utilisateur> listerUtilisateurParId() {
		return serviceLister.listerUtilisateurParId();
	}
	
	
//	@Override
//	public List<Utilisateur> listerUtilisateurParId() {
//		
//		return serviceLister.listerUtilisateurParId();
//	}

}
