package utilisateur.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aosp_specialiste")
public class Specialiste extends AbstractJardinier{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSpecialite", nullable = true)
	private Specialite specialite;
	
	public  Specialiste() {	
		super();
	}
	
	public Specialiste(EtatCivil etatCivil, String mail, String motPasse, 
			Collection<DroitUtilisateur> listeDroits, String codePostal, Specialite specialite){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
		setListeDroits(listeDroits);
		setCodePostal(codePostal);
		setSpecialite(specialite);
	}
	
	

	public Specialite getSpecialite() {
		return specialite;
	}


	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return super.toString()+" Specialiste [specialite=" + specialite + "]";
	}
}
