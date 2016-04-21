package utilisateur.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import utilisateur.util.Param;


/**
 * Entité implémentant la classe abstraite Utilisateur
 * @author Guillaume
 *
 */
@Entity
@Table(name = Param.TABLE_AOSP_UTILISATEUR)

// on utilise la strategy JOINED pour pouvoir avoir des contraintes de non nullité et la possibilité de d'avoir tous les mapping
// on aura une table par classe (même abstraite)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// id générée automatiquement. cela permet d'avoir toujours une clé unique automatiquement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ref_utilisateur")
	private int idUtilisateur;	//id de l'utilisateur
	
	// relation 1-1. cascadeType.ALL pour que toutes les opérations sur l'utilisateur(creer, modifier, supprimer)
	// soit répercutées sur l'EtatCivil
	// fetch = EAGER pour que EtatCivil soit chargé en même temps que Utilisateur
	@OneToOne ( cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idEtatcivil", unique = true, nullable = false)
	private EtatCivil etatCivil;		// état civil de l'utilisateur
	
	@Column(name="mail", length = 30, nullable = false)
	private String mail;				// mail de l'utilisateur
	
	@Column(name = "motPasse", length = 30, nullable = false)	
	private String motPasse;			// mot de passe de l'utilisateur

	// relation n-n : cascadeType DETACH pour que la les droits puisse être créés, modifiés ou supprimés indépendament
	// de l'utilisateur
	// fetch = EAGER pour que listeDroits soit chargé en même temps que Utilisateur (on a toujours besoin de connaître
	// la liste de droits)
	@ManyToMany(cascade= CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name="aosp_droits_utilisateur",
			joinColumns = @JoinColumn(name="idUtilisateur") ,
			 inverseJoinColumns = @JoinColumn(name="idDroit") )
	private Collection<DroitUtilisateur> listeDroits;		// liste des droits de l'utilisateur
	
		
	/**
	 * constructeur par défaut
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * constructeur initialisant les propriétés de l'utilisateur (sauf idUtilisateur qui sera généré automatiquement)
	 * @param etatCivil état civil de l'utilisateur
	 * @param mail mail de l'utilisateur
	 * @param motPasse mot de passe de l'utilisateur
	 * @param listeDroits liste des droits de l'utilisateur
	 */
	public Utilisateur(EtatCivil etatCivil, String mail, String motPasse, Collection<DroitUtilisateur> listeDroits) {
		super();
		this.etatCivil = etatCivil;
		this.mail = mail;
		this.motPasse = motPasse;
		this.listeDroits = listeDroits;
	}

	// ---- Ajouté par nicolas  -----
	public String getNom(){
		return getEtatCivil().getNom();
	}
	
	public void setNom(String nom){
		EtatCivil etatCivil = new EtatCivil();
		etatCivil.setNom(nom);
		setEtatCivil(etatCivil);
	}
	
	// -----------------------------

	
	//*************************** GETTERS et SETTERS
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public EtatCivil getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(EtatCivil etatCivil) {
		this.etatCivil = etatCivil;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public Collection<DroitUtilisateur> getListeDroits() {
		return listeDroits;
	}

	public void setListeDroits(Collection<DroitUtilisateur> listeDroits) {
		this.listeDroits = listeDroits;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", etatCivil=" + etatCivil + ", mail=" + mail
				+ ", motPasse=" + motPasse + ", listeDroits=" + listeDroits + "]";
	}
	
	

}
