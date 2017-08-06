package ofedorova.store;

import ofedorova.store.models.Role;
import ofedorova.store.storages.RoleStore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing class "RoleStore".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class RoleStoreTest {

    /**
     * Method test adding new element into store.
     */
    @Test
    public void whenAdd() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);

        assertThat(roleStore.toArray(), is(arrayOfRoles));
    }

    /**
     * Method tests when update element and return true.
     */
    @Test
    public void whenUpdateTrue() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role3, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(roleStore.update(role2.getId(), role3) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when update element and return false.
     */
    @Test
    public void whenUpdateFalse() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(!roleStore.update("10", role3) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when delete element and returns true.
     */
    @Test
    public void whenDeleteByElementTrue() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);

        assertTrue(roleStore.delete(role3) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when delete element and returns false.
     */
    @Test
    public void whenDeleteByElementFalse() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(!roleStore.delete(role3) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when delete element by identifier and returns deleting element.
     */
    @Test
    public void whenDeleteByIdTrue() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);

        assertTrue(role3.equals(roleStore.delete(role3.getId())) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when delete element by identifier and returns null.
     */
    @Test
    public void whenDeleteByIdFalse() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(null == roleStore.delete(role3.getId()) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when getting element by identifier and returns element.
     */
    @Test
    public void whenGettingByIdAndReturnElement() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(role2.equals(roleStore.delete(role2.getId())));
    }

    /**
     * Method tests when getting element by identifier and returns null.
     */
    @Test
    public void whenGettingByIdAndReturnNull() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(null == roleStore.delete("3"));
    }
}