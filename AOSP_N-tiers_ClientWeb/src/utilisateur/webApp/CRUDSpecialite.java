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
		System.out.println("creation spécialité");
		return SUCCESS;
	}
	public String modification(){	
		System.out.println("modification spécialité");

		return SUCCESS;
	}
	public String suppression(){
		System.out.println("suppression spécialité");

		return SUCCESS;
	}
	public String rechercherParId(){
		System.out.println("rechercherParId spécialité");

		return SUCCESS;
	}
	
	public String remplir(){
		System.out.println("remplir spécialité");

		return SUCCESS;
	}

}
