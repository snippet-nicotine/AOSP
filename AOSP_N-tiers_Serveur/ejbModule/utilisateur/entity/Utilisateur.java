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


@Entity
@Table(name = "aosp_utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ref_utilisateur")
	private int idUtilisateur;
	
	@OneToOne ( cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idEtatcivil", unique = true, nullable = true)
	private EtatCivil etatCivil;
	
	@Column(name="mail", length = 30, nullable = true)
	private String mail;
	
	@Column(name = "motPasse", length = 30, nullable = true)	
	private String motPasse;

	@ManyToMany(cascade= { CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinTable(name="aosp_droits_utilisateur",
			joinColumns = @JoinColumn(name="idUtilisateur") ,
			 inverseJoinColumns = @JoinColumn(name="idDroit") )
	private Collection<DroitUtilisateur> listeDroits;
	
		
	
	public Utilisateur() {
		super();
	}

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
