package ofedorova.start;

import ofedorova.models.Comment;
import ofedorova.models.Filter;
import ofedorova.models.FilterFactory;
import ofedorova.models.Item;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * The class for testing class "Tracker".
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class TrackerTest {
    
    @Test
    public void whenAddItems(){
        final Tracker tracker = new Tracker();
        final Item item1  = new Item("item1", "description1");
        assertThat(tracker.addItem(item1), is(item1));
    }
    
    @Test
    public void whenAddComment(){
        final Tracker tracker = new Tracker();
        final Item item1  = new Item("item1", "description1");
        tracker.addItem(item1);
        final Comment comment = new Comment(item1.getId(), "comment");
        assertThat(tracker.addComment(comment), is(item1));
    }
    
    @Test
    public void whenRemoveItem(){
        final Tracker tracker = new Tracker();
        final Item item1  = new Item("item1", "description1");
        final Item item2  = new Item("item2", "description2");
        final Item item3  = new Item("item3", "description3");
        tracker.addItem(item1);
        tracker.addItem(item2);
        tracker.addItem(item3);
        
        final Item[] checked = {item1, item3}; 
        tracker.removeItem(item2);
        assertThat(tracker.getItems(), is(checked));
    }
    
    @Test
    public void whenEditItem(){
        final Tracker tracker = new Tracker();
        final Item item1  = new Item("item1", "description1");
        final Item item2  = new Item("item2", "description2");
        final Item item3  = new Item("item3", "description3");
        tracker.addItem(item1);
        tracker.addItem(item2);
        tracker.addItem(item3);
        
        final Item checked = new Item("checked item", "checked description");
        checked.setId(item2.getId());
        tracker.editItem(checked);
        assertThat(tracker.getItems()[1], is(checked));
    }
    
    @Test
    public void whenGetItems(){
        final Tracker tracker = new Tracker();
        final Item item1  = new Item("item1", "description1");
        final Item item2  = new Item("item2", "description2");
        final Item item3  = new Item("item3", "description3");
        tracker.addItem(item1);
        tracker.addItem(item2);
        tracker.addItem(item3);
        
         final Item[] checked = {item1, item2, item3};
         assertThat(tracker.getItems(), is(checked));
    }
    
    @Test
    public void whenGetItemsByFilter(){
        final Tracker tracker = new Tracker();
        final Item item1  = new Item("item1", "description1");
        final Item item2  = new Item("task2", "description2");
        final Item item3  = new Item("item3", "description3");
        final Item item4  = new Item("task4", "description4");
        tracker.addItem(item1);
        tracker.addItem(item2);
        tracker.addItem(item3);
        tracker.addItem(item4);
        
        final Filter filter = new FilterFactory().getFilter("name", "item");
        final Item[] checked = {item1, item3};
        assertThat(tracker.getItems(filter), is(checked));
    }
    
}
