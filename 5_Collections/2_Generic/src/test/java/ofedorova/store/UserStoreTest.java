package ofedorova.store;

import ofedorova.store.models.User;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing class "UserStore".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class UserStoreTest {
    /**
     * Method test adding new element into store.
     */
    @Test
    public void whenAdd() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);

        assertThat(userStore.toArray(), is(arrayOfUsers));
    }

    /**
     * Method tests when update element and return true.
     */
    @Test
    public void whenUpdateTrue() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user3, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(userStore.update(1, user3) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when update element and return false.
     */
    @Test
    public void whenUpdateFalse() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(!userStore.update(10, user3) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when delete element and returns true.
     */
    @Test
    public void whenDeleteByElementTrue() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);

        assertTrue(userStore.delete(user3) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when delete element and returns false.
     */
    @Test
    public void whenDeleteByElementFalse() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(!userStore.delete(user3) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when delete element by index and returns deleting element.
     */
    @Test
    public void whenDeleteByIndexTrue() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);

        assertTrue(user3.equals(userStore.delete(2)) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when delete element by index and returns null.
     */
    @Test
    public void whenDeleteByIndexFalse() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(null == userStore.delete(2) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when getting element by index and returns element.
     */
    @Test
    public void whenGettingByIndexAndReturnElement() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(user2.equals(userStore.delete(1)));
    }

    /**
     * Method tests when getting element by index and returns null.
     */
    @Test
    public void whenGettingByIndexAndReturnNull() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(null == userStore.delete(2));
    }


}