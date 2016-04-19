package utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public abstract class AbstractJardinier extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String codePostal;
	
	
	

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
