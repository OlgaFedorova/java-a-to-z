package models;

import ofedorova.models.Item;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * The class for testing the class "Item".
 * @author Olga Fedorova
 * @since 17.08.2016
 * @version 1
 */
public class ItemTest {
    
    @Test 
    public void whenGetComments(){
        final Item item = new Item ("item1", "item1", "comment1");
        item.addComment("comment2");
        item.addComment("comment3");
        
        final String[] checked = {"comment1", "comment2", "comment3"};
        assertThat(item.getComments(), is(checked));
    }
    
    @Test 
    public void whenAddComment(){
        final Item item = new Item ("item1", "item1", "comment1");
        item.addComment("comment2");
        item.addComment("comment3");
        item.addComment("comment4");
        item.addComment("comment5");
        item.addComment("comment6");
        item.addComment("comment7");
        item.addComment("comment8");
        item.addComment("comment9");
        item.addComment("comment10");
        item.addComment("comment11");
        item.addComment("comment12");
        item.addComment("comment13");
        item.addComment("comment14");
        
        final String[] checked = {"comment1", "comment2", "comment3",
                                  "comment4", "comment5", "comment6", 
                                  "comment7", "comment8", "comment9", 
                                  "comment10", "comment11", "comment12", 
                                  "comment13", "comment14"};
        assertThat(item.getComments(), is(checked));
    }
    
    
    
}
