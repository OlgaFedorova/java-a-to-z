package ofedorova.store.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class UserTest {
    /**
     * Method tests getting id.
     */
    @Test
    public void whenGetId() {
        final String id = "1";
        final Base base = new User(id);

        assertThat(base.getId(), is(id));
    }

    /**
     * Method tests setting is.
     */
    @Test
    public void setId() {
        final String id = "2";
        final Base base = new User("1");
        base.setId(id);

        assertThat(base.getId(), is(id));
    }

}