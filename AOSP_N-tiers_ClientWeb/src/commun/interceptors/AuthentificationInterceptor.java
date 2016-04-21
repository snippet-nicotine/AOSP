package commun.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import utilisateur.entity.Utilisateur;

public class AuthentificationInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
        
        Utilisateur user = (Utilisateur) sessionAttributes.get("USER");
         
        if(user == null){
            return Action.LOGIN;
        }else{
            Action action = (Action) actionInvocation.getAction();
            if(action instanceof UtilisateurAware){
                ((UtilisateurAware) action).setUtilisateur(user);
            }
            return actionInvocation.invoke();
        }
	}

}
