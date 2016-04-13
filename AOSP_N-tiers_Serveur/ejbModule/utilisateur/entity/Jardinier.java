package utilisateur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import potager.entity.Potager;

@Entity
@Table(name="aosp_jardinier")
public class Jardinier extends AbstractJardinier {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ManyToMany(mappedBy="visiteurs", 	fetch=FetchType.EAGER)
	private List<Potager> potagerPartages;	
	
		
	public Jardinier() {
		super();
	}
	
	public Jardinier(EtatCivil etatCivil, String mail, String motPasse, String codePostal){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
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
		// TODO Auto-generated method stub
		
	}

	
	public List<Potager> getPotagerPartages() {
		return potagerPartages;
	}

	public void setPotagerPartages(List<Potager> potagerPartages) {
		this.potagerPartages = potagerPartages;
	}


}