package utilisateur.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import utilisateur.util.Param;

/**
 * Entité implémentant les Spécialistes
 * @author Guillaume
 *
 */
@Entity
@Table(name=Param.TABLE_AOSP_SPECIALISTE)
public class Specialiste extends AbstractJardinier{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// relation 1-n : cascadeType DETACH pour que les spécialités puissent être crées indépendament du Spécialiste
	// fetch = EAGER pour que la spécialité soit chargée en même temps que le spécialiste (on a toujours besoin de 
	// connaître la spécialité)
	@ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSpecialite", nullable = true)
	private Specialite specialite;	// spécialité du spécialiste
	
	/**
	 * Constructeur par défaut
	 */
	public  Specialiste() {	
		super();
	}
	
	/**
	 * constructeur initialisant les propriétés du spécialiste sauf IdUtilisateur qui est générée automatiquement
	 * @param etatCivil état civil du spécialiste
	 * @param mail mail du spécialiste
	 * @param motPasse mot de passe du spécialiste
	 * @param listeDroits liste des droits du spécialiste
	 * @param codePostal code postal du spécialiste
	 * @param specialite spécialité du spécialiste
	 */
	public Specialiste(EtatCivil etatCivil, String mail, String motPasse, 
			Collection<DroitUtilisateur> listeDroits, String codePostal, Specialite specialite){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
		setListeDroits(listeDroits);
		setCodePostal(codePostal);
		setSpecialite(specialite);
	}
	
	
//*********************** GETTERS et SETTERS
	
	public Specialite getSpecialite() {
		return specialite;
	}


	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	//**** toString
	@Override
	public String toString() {
		return super.toString()+" Specialiste [specialite=" + specialite + "]";
	}
}
