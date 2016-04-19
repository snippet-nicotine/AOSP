package utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aosp_abstract_jardinier")
public abstract class AbstractJardinier extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="code_postal", length = 30, nullable = true)
	private String codePostal;
	
	
	

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return super.toString()+" AbstractJardinier [codePostal=" + codePostal + "]";
	}

}
