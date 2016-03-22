package planning.util;

/**
 * Classe impléméntant des constantes chaines
 * @author Didier
 *
 */
public class ConstanteString {

	public static final String PAGE_ACCUEIL_CRUD_PLANIFIER = "planifier_depart.jsp";

	public static final String DESTINATION_NAME  = "/ConnectionFactory";
	public static final String JMS_QUEUE_JNDI	 = "/jboss/exported/jms/queue/TestDMQueue"; 
	public static final String JMS_USERNAME	 	 = "jmsuser";       
	public static final String JMS_PASSWORD	 	 = "jmsuser@123";
	
	public static final String INITIAL_CONTEXTE_EJB = "ejb:/AOSP_N-tiers_Serveur/FacadeService!planning.clientServeur.IService";
}
