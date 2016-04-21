package utilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import utilisateur.util.Param;

/**
 * Entité qui implémente un jardinier abstrait qui possède un code postal en plus des propriétés de sa classe mère (Utilisateur)
 * @author Guillaume
 *
 */
@Entity
@Table(name = Param.TABLE_AOSP_ABSTRACT_JARDINIER)
public abstract class AbstractJardinier extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="code_postal", length = 30, nullable = true)
	private String codePostal;	// code postal de l'abstract jardinier
	
	
	
	// ********************* GETTER et SETTER
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
