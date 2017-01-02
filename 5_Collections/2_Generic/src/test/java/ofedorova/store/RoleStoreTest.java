package ofedorova.store;

import ofedorova.store.models.Role;
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

        assertTrue(roleStore.update(1, role3) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
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

        assertTrue(!roleStore.update(10, role3) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
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
     * Method tests when delete element by index and returns deleting element.
     */
    @Test
    public void whenDeleteByIndexTrue() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);

        assertTrue(role3.equals(roleStore.delete(2)) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when delete element by index and returns null.
     */
    @Test
    public void whenDeleteByIndexFalse() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");
        final Role role3 = new Role("3");
        final Role[] arrayOfRoles = {role1, role2, null, null, null, null, null, null, null, null};

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(null == roleStore.delete(2) && Arrays.equals(roleStore.toArray(), arrayOfRoles));
    }

    /**
     * Method tests when getting element by index and returns element.
     */
    @Test
    public void whenGettingByIndexAndReturnElement() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(role2.equals(roleStore.delete(1)));
    }

    /**
     * Method tests when getting element by index and returns null.
     */
    @Test
    public void whenGettingByIndexAndReturnNull() {
        final RoleStore roleStore = new RoleStore();
        final Role role1 = new Role("1");
        final Role role2 = new Role("2");

        roleStore.add(role1);
        roleStore.add(role2);

        assertTrue(null == roleStore.delete(2));
    }
}