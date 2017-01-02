package ofedorova;

import ofedorova.DataBase.VerifierForUserOfDB;
import ofedorova.prototype.VerifierForUser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The class is for testing class "VerifierForUserOfDB".
 *
 * @author Olga Fedorova
 * @since 30.10.2016
 * @version 1
 */
public class VerifierForUserOfDBTest {
    
    private final VerifierForUser verifier = new VerifierForUserOfDB();
    
    @Test
    public void testCheckIdTrue(){
        assertTrue(verifier.checkId("1000000"));
        assertTrue(verifier.checkId("1543423"));
    }
    
    @Test
    public void testCheckIdFalse(){
        assertFalse(verifier.checkId("100000"));
        assertFalse(verifier.checkId("1uuuuuu"));
        assertFalse(verifier.checkId("2000056"));
    }
    
    @Test
    public void testCheckNameTrue(){
        assertTrue(verifier.checkName("dsds34jkj42ddhjklgfdrtyuiof789"));
    }
    
    @Test
    public void testCheckNameFalse(){
        assertFalse(verifier.checkName("32424dfsgss232"));
        assertFalse(verifier.checkName("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"));
    }
    
    @Test
    public void testCheckAgeTrue(){
        assertTrue(verifier.checkAge("18"));
    
    }
    
    @Test
    public void testCheckAgeFalse(){
        assertFalse(verifier.checkAge("1"));
        assertFalse(verifier.checkAge("167"));
        assertFalse(verifier.checkAge("dg"));
        assertFalse(verifier.checkAge("06"));
    }
}
