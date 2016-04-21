package utilisateur.exception;

public class CodePostalNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messageSup;
	
	
	public CodePostalNullException(String messageSup){
		this.messageSup=messageSup;
	}


	public String getMessageSup() {
		return messageSup;
	}


	public void setMessageSup(String messageSup) {
		this.messageSup = messageSup;
	}

}
