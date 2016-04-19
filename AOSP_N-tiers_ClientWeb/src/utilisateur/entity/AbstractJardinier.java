package utilisateur.entity;

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

	@Override
	public String toString() {
		return super.toString()+" AbstractJardinier [codePostal=" + codePostal + "]";
	}
}
