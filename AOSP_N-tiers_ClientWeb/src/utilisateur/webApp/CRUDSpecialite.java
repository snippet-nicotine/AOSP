package utilisateur.webApp;

public class CRUDSpecialite extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	
	public String affiche(){		
		return SUCCESS;
	}
	
	public String creation(){
		System.out.println("creation sp�cialit�");
		return SUCCESS;
	}
	public String modification(){	
		System.out.println("modification sp�cialit�");

		return SUCCESS;
	}
	public String suppression(){
		System.out.println("suppression sp�cialit�");

		return SUCCESS;
	}
	public String rechercherParId(){
		System.out.println("rechercherParId sp�cialit�");

		return SUCCESS;
	}
	
	public String remplir(){
		System.out.println("remplir sp�cialit�");

		return SUCCESS;
	}

}
