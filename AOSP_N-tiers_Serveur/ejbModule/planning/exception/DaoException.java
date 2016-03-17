package planning.exception;

/**
 * Classe d'exception utilis�e pour la couche dao
 * @author Didier
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException(String message, Throwable e) {
		super(message, e);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException() {
	}
}
