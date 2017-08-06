package ofedorova.start;

import ofedorova.models.Comment;
import ofedorova.models.FilterFactory;
import ofedorova.models.Item;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The class for testing class "StubInput".
 * @author Olga Fedorova
 * @since 24.08.2016
 * @version 1
 */
public class StubInputTest {
    
   private Item itemStart;
   
   @Before
   public void setStartValue(){
       
       itemStart = new Item("name2", "description2");
       itemStart.setId("0001");
   } 
    
    @Test
    public void testWithStubInput(){
        String[] answers = {"1", "name1", "description1", //add first item
                            "1", "name3", "description3", //add third item
                            "1", "name4", "description5", //add third item
                            "2", "0001", "name2", "description2",//edit the item
                            "4", //show all item
                            "6", "0001", "comment1",//Add new comment into the item
                            "3", "0001",//Remove the item
                            "7", "Y"};// Exit 


        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(input, tracker);
        menuTracker.fillAction();
        int countAdd = 0;

        while (!menuTracker.isExit()) {

            String operation = input.ask("Select the operation: ");
            if (operation.equals("2")){
                tracker.getItems()[1].setId(itemStart.getId());
            }
            
            menuTracker.select(Integer.valueOf(operation));
            switch(operation){
                case "1": //add first item
                    countAdd++;
                    assertThat(tracker.getItems().length, is(countAdd));
                    break;
                case "2": //Edit the item
                    assertEquals("", itemStart, tracker.getItems()[1]);
                    break;
                case "3": //Remove the item
                    assertThat(tracker.getItems().length, is(2));
                    break;
                case "4"://Show all items
                    assertThat(tracker.getItems().length, is(3));
                    break;
                case "6": //Add new comment into the item
                    assertThat(tracker.getItems()[1].getComments().length, is(1));
                    break;
            }
        }
    }
}
