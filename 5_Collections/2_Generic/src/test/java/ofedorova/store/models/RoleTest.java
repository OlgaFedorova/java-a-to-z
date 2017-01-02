package ofedorova.store.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class "Role".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class RoleTest {
    /**
     * Method tests getting id.
     */
    @Test
    public void whenGetId() {
        final String id = "1";
        final Base base = new Role(id);

        assertThat(base.getId(), is(id));
    }

    /**
     * Method tests setting is.
     */
    @Test
    public void setId() {
        final String id = "2";
        final Base base = new Role("1");
        base.setId(id);

        assertThat(base.getId(), is(id));
    }

}