package ofedorova;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class for testing class EngineeringCalc.
 * @author Olga Fedorova
 * @since 22.09.2016
 * @version 1
 */
public class EngineeringCalcTest {
    
    private final double number = 10.506;
    
    @Test
    public void testSinAction(){
        final EngineeringCalc calc = new EngineeringCalc();
        calc.setOperand(this.number);
        calc.select("sin");
        
        assertThat(calc.getResult(), is(Math.sin(this.number)));
        
    }
    
    @Test
    public void testCosAction(){
        final EngineeringCalc calc = new EngineeringCalc();
        calc.setOperand(this.number);
        calc.select("cos");
        
        assertThat(calc.getResult(), is(Math.cos(this.number)));
    }
    
    @Test
    public void testTgAction(){
        final EngineeringCalc calc = new EngineeringCalc();
        calc.setOperand(this.number);
        calc.select("tg");
        
        assertThat(calc.getResult(), is(Math.tan(this.number)));
    }
    
    @Test
    public void testCtgAction(){
        final EngineeringCalc calc = new EngineeringCalc();
        calc.setOperand(this.number);
        calc.select("ctg");
        
        assertThat(calc.getResult(), is(Math.cos(this.number) / Math.sin(this.number)));
    }
}
