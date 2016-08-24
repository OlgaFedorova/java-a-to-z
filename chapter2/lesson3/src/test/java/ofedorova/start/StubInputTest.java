package ofedorova.start;

import ofedorova.start.StartUI;
import org.junit.Test;

/**
 * The class for testing class "StubInput".
 * @author Olga Fedorova
 * @since 24.08.2016
 * @version 1
 */
public class StubInputTest {
    
@Test
public void testWithStubInput(){
    String[] answers = {"1", "item1", "description1", //add first item
                        "1", "item2", "description2", //add second item
                        "1", "name", "description", //add third item
                        "4", //show all item
                        "5", "name", "2", // show id by filter
                        "7", "Y"};// Exit 
    StartUI startUI = new StartUI(new StubInput(answers));
    startUI.init();
    
}

}
