package ofedorova.store;

import ofedorova.store.models.User;
import ofedorova.store.storages.UserStore;
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

        assertTrue(userStore.update(user2.getId(), user3) && Arrays.equals(userStore.toArray(), arrayOfUsers));
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

        assertTrue(!userStore.update("10", user3) && Arrays.equals(userStore.toArray(), arrayOfUsers));
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
     * Method tests when delete element by identifier and returns deleting element.
     */
    @Test
    public void whenDeleteByIdTrue() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);

        assertTrue(user3.equals(userStore.delete(user3.getId())) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when delete element by identifier and returns null.
     */
    @Test
    public void whenDeleteByIdFalse() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final User[] arrayOfUsers = {user1, user2, null, null, null, null, null, null, null, null};

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(null == userStore.delete(user3.getId()) && Arrays.equals(userStore.toArray(), arrayOfUsers));
    }

    /**
     * Method tests when getting element by identifier and returns element.
     */
    @Test
    public void whenGettingByIdAndReturnElement() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(user2.equals(userStore.delete(user2.getId())));
    }

    /**
     * Method tests when getting element by identifier and returns null.
     */
    @Test
    public void whenGettingByIdAndReturnNull() {
        final UserStore userStore = new UserStore();
        final User user1 = new User("1");
        final User user2 = new User("2");

        userStore.add(user1);
        userStore.add(user2);

        assertTrue(null == userStore.delete("3"));
    }


}