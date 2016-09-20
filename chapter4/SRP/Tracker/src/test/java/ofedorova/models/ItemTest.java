package ofedorova.models;

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
        Comment comment1 = new Comment("1", "comment1");
        Comment comment2 = new Comment("1", "comment2");
        Comment comment3 = new Comment("1", "comment3");
        final Item item = new Item ("item1", "item1");
        item.addComment(comment1);
        item.addComment(comment2);
        item.addComment(comment3);
        
        final Comment[] checked = {comment1, comment2, comment3};
        assertThat(item.getComments(), is(checked));
    }
    
    @Test 
    public void whenAddComment(){
        Comment comment1 = new Comment("1", "comment1");
        Comment comment2 = new Comment("1", "comment2");
        Comment comment3 = new Comment("1", "comment3");
        Comment comment4 = new Comment("1", "comment4");
        Comment comment5 = new Comment("1", "comment5");
        Comment comment6 = new Comment("1", "comment6");
        Comment comment7 = new Comment("1", "comment7");
        Comment comment8 = new Comment("1", "comment8");
        Comment comment9 = new Comment("1", "comment9");
        Comment comment10 = new Comment("1", "comment10");
        Comment comment11 = new Comment("1", "comment11");
        Comment comment12 = new Comment("1", "comment12");
        Comment comment13 = new Comment("1", "comment13");
        Comment comment14 = new Comment("1", "comment14");
        final Item item = new Item ("item1", "item1");
        item.addComment(comment1);
        item.addComment(comment2);
        item.addComment(comment3);
        item.addComment(comment4);
        item.addComment(comment5);
        item.addComment(comment6);
        item.addComment(comment7);
        item.addComment(comment8);
        item.addComment(comment9);
        item.addComment(comment10);
        item.addComment(comment11);
        item.addComment(comment12);
        item.addComment(comment13);
        item.addComment(comment14);
        
        final Comment[] checked = {comment1, comment2, comment3,
                                  comment4, comment5, comment6, 
                                  comment7, comment8, comment9, 
                                  comment10, comment11, comment12, 
                                  comment13, comment14};
        assertThat(item.getComments(), is(checked));
    }
    
}
