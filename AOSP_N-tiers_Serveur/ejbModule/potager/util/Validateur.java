package potager.util;

import java.util.regex.Pattern;

public class Validateur {
	
	public static boolean checkCodePostal(String codePostal) {
		
		String  regex = "^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$";		 
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(codePostal).matches();
		
	}

}
