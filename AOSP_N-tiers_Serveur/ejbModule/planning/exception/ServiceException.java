package planning.exception;

/**
 * Classe d'exception utilisée pour la couche Service et
 * utilisée pourremonter les exceptions du coté client.
 * @author Didier
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

}
