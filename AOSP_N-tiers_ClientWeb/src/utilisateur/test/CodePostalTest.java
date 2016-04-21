package utilisateur.test;

import static org.junit.Assert.*;

import org.junit.Test;

import utilisateur.exception.CodePostalNullException;
import utilisateur.util.VerifCodePostal;

public class CodePostalTest {	
	

	// cas nominal
	@Test
	public void testCodeOK() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode("13013"),true);
		} catch (CodePostalNullException e) {
			e.printStackTrace();
		}
	}
	
	// cas code=null
	@Test
	public void testCodeNull() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode(null),false);
			
			// si l'exception n'est pas levée
			fail("Exception non levée !");
		} catch (CodePostalNullException e) {			
			// on ne fait rien si l'exception est levée
		}
	}
	
	// cas nombre pas entier
	@Test
	public void testCodePasEntier() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode("01.23"),false);
		} catch (CodePostalNullException e) {
			e.printStackTrace();
		}
	}

	// cas pas assez de caractères (4)
	@Test
	public void testCode4Caracteres() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode("1223"),false);
		} catch (CodePostalNullException e) {
			e.printStackTrace();
		}
	}
	
	// cas pas assez de caractères (1)
	@Test
	public void testCode1Caractere() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode("1"),false);
		} catch (CodePostalNullException e) {
			e.printStackTrace();
		}
	}
	
	// cas pas assez de caractères (0)
	@Test
	public void testCode0Caractere() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode(""),false);
		} catch (CodePostalNullException e) {
			e.printStackTrace();
		}
	}
	
	// cas trop de carctères (6)
	@Test
	public void testCode6Caracteres() {
		try {
			assertEquals("Code OK",VerifCodePostal.verifCode("123456"),false);
		} catch (CodePostalNullException e) {
			e.printStackTrace();
		}
	}
	
	// cas 5 caractères avec 1 lettre
		@Test
		public void testCodeAvecLettre() {
			try {
				assertEquals("Code OK",VerifCodePostal.verifCode("a1234"),false);
			} catch (CodePostalNullException e) {
				e.printStackTrace();
			}
		}

}
