package utilisateur.clientServeur;


/**
 * Classe implementant une exception perso.
 * @author Guillaume
 *
 */
public class NonTrouveServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String messagePerso;

	public NonTrouveServiceException(String messagePerso){
		this.messagePerso=messagePerso;
	}

	public String getMessagePerso() {
		return messagePerso;
	}

	public void setMessagePerso(String messagePerso) {
		this.messagePerso = messagePerso;
	}

}
