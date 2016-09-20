package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Olga on 15.07.2016.
 */
public class CalculatorTest {

    @Test
    public void whenAdd() throws Exception {
        final Calculator calculator = new Calculator();
        double checked = 5d;

        calculator.add(3, 2);

        final double result = calculator.getResult();
        assertThat(result, is(checked));
    }

    @Test
    public void whenSubstruct() throws Exception {
        final Calculator calculator = new Calculator();
        double checked = 1d;

        calculator.substruct(3, 2);
        final double result = calculator.getResult();

        assertThat(result, is(checked));
    }

    @Test
    public void whenDiv() throws Exception {
        final Calculator calculator = new Calculator();
        double checked = 3d;

        calculator.div(6, 2);
        final double result = calculator.getResult();

        assertThat(result, is(3d));
    }

    @Test
    public void whenMultiple() throws Exception {
        final Calculator calculator = new Calculator();
        double checked = 6d;

        calculator.multiple(3, 2);
        final double result = calculator.getResult();

        assertThat(result, is(checked));
    }
}