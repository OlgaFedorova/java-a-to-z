package ofedorova.store.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing class "Base".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class BaseTest {
    /**
     * Method test when two object is equals.
     */
    @Test
    public void whenEqualsTrue() {
        final Base base1 = new User("1");
        final Base base2 = new User("1");

        assertTrue(base1.equals(base2));
    }

    /**
     * Method test when object is equals itself.
     */
    @Test
    public void whenEqualsItselfTrue() {
        final Base base1 = new User("1");

        assertTrue(base1.equals(base1));
    }

    /**
     * Method test when two object isn't equals.
     */
    @Test
    public void whenEqualsFalse() {
        final Base base1 = new User("1");
        final Base base2 = new Role("1");

        assertFalse(base1.equals(base2));
    }

    /**
     * Method test when two object isn't equals, and one from them is null.
     */
    @Test
    public void whenNullEqualsFalse() {
        final Base base1 = new User("1");
        final Base base2 = null;

        assertFalse(base1.equals(base2));
    }

    /**
     * Method test when getting hashcode from two equals objects.
     */
    @Test
    public void whenGetHashCode() {
        final Base base1 = new User("1");
        final Base base2 = new User("1");

        assertTrue(base1.hashCode() == base2.hashCode());
    }

}