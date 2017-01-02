package ofedorova;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 *Class for testing class TestTask
 *@author Olga Fedorova
 *@since 01.08.2016
 *@version 2
 */
public class TestTaskTest {
    
    public TestTaskTest() {
    }
    
    @Test
    public void whenCheckContainsOutOfBoundStart(){
        final String origin = "string";
        final String sub = "pst";
        
        final boolean checked = false;
        final boolean result = new TestTask().contains(origin, sub);
        
        assertThat(result, is(checked));
        
    }
    
    @Test
    public void whenCheckContainsOnBoundStart(){
        final String origin = "stRing";
        final String sub = " sTr";
        
        final boolean checked = true;
        final boolean result = new TestTask().contains(origin, sub);
        
        assertThat(result, is(checked));
    }
    
    @Test
    public void whenCheckContainsInside(){
        final String origin = "string";
        final String sub = "tri";
        
        final boolean checked = true;
        final boolean result = new TestTask().contains(origin, sub);
        
        assertThat(result, is(checked));
    }
    
    @Test
    public void whenCheckContainsOnBoundEnd(){
        final String origin = "string";
        final String sub = "ring";
        
        final boolean checked = true;
        final boolean result = new TestTask().contains(origin, sub);
        
        assertThat(result, is(checked));
    }
    
    @Test
    public void whenCheckContainsOutOfBoundEnd(){
        final String origin = "string";
        final String sub = "inga";
        
        final boolean checked = false;
        final boolean result = new TestTask().contains(origin, sub);
        
        assertThat(result, is(checked));
    }
    
}
