package utilisateur.exception;

public class NonTrouveDAOException extends  Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messagePerso;
	
	public NonTrouveDAOException(String messagePerso){
		this.messagePerso=messagePerso;
	}

	
	public String getMessagePerso() {
		return messagePerso;
	}

	public void setMessagePerso(String messagePerso) {
		this.messagePerso = messagePerso;
	}

}
