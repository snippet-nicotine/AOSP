package utilisateur.util;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.exception.CodePostalNullException;

/**
 * Classe impl�mentant un service de v�rification du code postal
 * @author Guillaume
 *
 */
@Stateless
@LocalBean
public class VerifCodePostal {

	/**
	 * M�thode qui v�rifie la validit� d'un code postal. Un code postal doit �tre compos� de 5 chiffres
	 * @param code code postal � v�rifier
	 * @return true si le code est valide, false sinon
	 * @throws CodePostalNullException 
	 */
	public static boolean verifCode(String code) throws CodePostalNullException{
		boolean retour=true;
		
		if (code==null) throw new CodePostalNullException("Code postal null !");
		else if(code.trim().length()!=5) retour=false;
		if(retour){
			// on essaye de parser en int le code. Permet de v�rifier que le code est un nombre entier
			try{
				Integer.parseInt(code);			 
			}
			catch(NumberFormatException e){
				// si le parsing en int n'a pas fonctionn�, retour = false. Autrement le code est bon
				retour = false; 
			}
		}

		return retour;
	}
}
