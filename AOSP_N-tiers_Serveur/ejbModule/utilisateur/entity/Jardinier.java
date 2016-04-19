package utilisateur.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import potager.entity.Potager;

@Entity
@Table(name="aosp_jardinier")
public class Jardinier extends AbstractJardinier {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Ajout� par nicolas
	@OneToMany(mappedBy="proprietaire", cascade = {CascadeType.ALL} )
	private List<Potager> potagers;

	// Ajout� par nicolas.
	@ManyToMany(mappedBy="visiteurs", fetch=FetchType.EAGER)
	private List<Potager> potagerPartages;

	public Jardinier() {
		super();
	}
	
	public Jardinier(EtatCivil etatCivil, String mail, String motPasse,
			Collection<DroitUtilisateur> listeDroits, String codePostal){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
		setListeDroits(listeDroits);
		setCodePostal(codePostal);
	}
	
	public Jardinier(EtatCivil etatCivil, String mail, String motPasse, String codePostal, 
			List<Potager> potagerPartages){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
		setCodePostal(codePostal);
		setPotagerPartages(potagerPartages);
	}


	public void clean() {
	}

	// Ajout� par nicolas
	public List<Potager> getPotagers() {
		return potagers;
	}
	
	// Ajout� par nicolas
	public void setPotagers(List<Potager> potagers) {
		this.potagers = potagers;
	}
	
	// Ajout� par nicolas
	public List<Potager> getPotagerPartages() {
		return potagerPartages;
	}

	// Ajout� par nicolas
	public void setPotagerPartages(List<Potager> potagerPartages) {
		this.potagerPartages = potagerPartages;
	}

	@Override
	public String toString() {
		return super.toString()+" Jardinier [potagers=" + potagers + ", potagerPartages=" + potagerPartages + "]";
	}


}