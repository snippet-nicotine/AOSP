package utilisateur.webApp;

public class CRUDUtilisateur extends MyActionSupport {

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
		System.out.println("creation");
		return SUCCESS;
	}
	public String modification(){	
		System.out.println("modification");

		return SUCCESS;
	}
	public String suppression(){
		System.out.println("suppression");

		return SUCCESS;
	}
	public String rechercherParId(){
		System.out.println("rechercherParId");

		return SUCCESS;
	}
	
	public String remplir(){
		System.out.println("remplir");

		return SUCCESS;
	}
	

}
