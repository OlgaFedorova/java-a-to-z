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
                            "2", "0001", "name2", "description2",//edit the item
                            "4", //show all item
                            "5", "name", "2", // show id by filter
                            "6", "0001", "comment1",//Add new comment into the item
                            "3", "0001",//Remove the item
                            "7", "Y"};// Exit 


        boolean exit = false;
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        int countAdd = 0;

        while (!exit) {

            String operation = input.ask("Select the operation: ");
            switch(operation){
                case "1": //add first item
                    String name = input.ask("Input a name of item: ");
                    String description = input.ask("Input a description of item: ");
                    tracker.addItem(new Item(name, description));
                    countAdd++;
                    assertThat(tracker.getItems().length, is(countAdd));
                    break;
                case "2": //Edit the item
                    String id = input.ask("Input the id of item: ");
                    name = input.ask("Input new name of item: ");
                    description = input.ask("Input new description of item: ");
                    Item itemEdit = new Item(name, description);
                    itemEdit.setId(id);
                    tracker.getItems()[1].setId(id);
                    tracker.editItem(itemEdit);
                    assertEquals("", itemStart, tracker.getItems()[1]);
                    break;
                case "3": //Remove the item
                    id = input.ask("Input the id of item: ");
                    tracker.removeItem(tracker.findById(id));
                    assertThat(tracker.getItems().length, is(1));
                    break;
                case "4"://Show all items
                    assertThat(tracker.getItems().length, is(2));
                    break;
                case "5"://Show items by filter
                    String key = input.ask("Input the field for finding items: ");
                    String value = input.ask("Input the value of field for finding items: ");
                    assertEquals("", itemStart, tracker.getItems(new FilterFactory().getFilter(key, value))[0]);
                    break;
                case "6": //Add new comment into the item
                    id = input.ask("Input the id of item: ");
                    String commentSting = input.ask("Input new comment for the item: ");
                    Comment comment = new Comment(id, commentSting);
                    tracker.addComment(comment);
                    assertEquals("", comment, tracker.getItems()[1].getComments()[0]);
                    break;
                case "7"://Exit
                    String answerExit = input.ask("Are you sure? Y/N: ");
                    if(answerExit.equals("Y")){
                        exit = true;
                   }
                   break;
                }

        }

    }
}
