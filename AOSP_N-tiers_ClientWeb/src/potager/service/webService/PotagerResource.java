package potager.service.webService;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import commun.config.Parametres;
import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import potager.service.exception.DaoPotagerQueryException;

@Path("/potagers")
public class PotagerResource {
	
	ServiceGestionPotager serviceGestionPotager;
	
    @GET
    @Produces("text/json")
    public String listerPotagers( ) {
    	
    	InitialContext initialContext;


		try {
			initialContext = new InitialContext();
			serviceGestionPotager = (ServiceGestionPotager) initialContext.lookup( Parametres.EJB_SERVICE_GESTION_POTAGER );
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
    	
    	try {
    		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    		   
			List<Potager> potagers = serviceGestionPotager.listerPotager();
			String json = gson.toJson(potagers);
						
			return json;
			
		} catch (DaoPotagerQueryException e) {
			e.printStackTrace();
		}
    	
    	return "{\"erreurs\" : \"Problème\"}";
    	
		
    }


}