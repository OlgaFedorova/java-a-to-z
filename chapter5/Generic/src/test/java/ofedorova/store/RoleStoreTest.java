package ofedorova.store;

import ofedorova.store.models.Role;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class "RoleStore".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class RoleStoreTest {
    /**
     * Method tests getting store.
     */
    @Test
    public void whenGetStore() {
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final RoleStore roleStore = new RoleStore();
        final Role[] roles = new Role[]{role1, role2, role3, null, null, null, null, null, null, null};

        roleStore.getStore().add(role1);
        roleStore.getStore().add(role2);
        roleStore.getStore().add(role3);

        assertThat(roleStore.getStore().toArray(), is(roles));
    }

}