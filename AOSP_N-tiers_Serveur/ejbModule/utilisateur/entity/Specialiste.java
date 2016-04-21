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
 * Entit� impl�mentant les Sp�cialistes
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

	// relation 1-n : cascadeType DETACH pour que les sp�cialit�s puissent �tre cr�es ind�pendament du Sp�cialiste
	// fetch = EAGER pour que la sp�cialit� soit charg�e en m�me temps que le sp�cialiste (on a toujours besoin de 
	// conna�tre la sp�cialit�)
	@ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSpecialite", nullable = true)
	private Specialite specialite;	// sp�cialit� du sp�cialiste
	
	/**
	 * Constructeur par d�faut
	 */
	public  Specialiste() {	
		super();
	}
	
	/**
	 * constructeur initialisant les propri�t�s du sp�cialiste sauf IdUtilisateur qui est g�n�r�e automatiquement
	 * @param etatCivil �tat civil du sp�cialiste
	 * @param mail mail du sp�cialiste
	 * @param motPasse mot de passe du sp�cialiste
	 * @param listeDroits liste des droits du sp�cialiste
	 * @param codePostal code postal du sp�cialiste
	 * @param specialite sp�cialit� du sp�cialiste
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
