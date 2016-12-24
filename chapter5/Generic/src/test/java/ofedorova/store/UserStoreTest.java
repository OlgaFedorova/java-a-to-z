package ofedorova.store;

import ofedorova.store.models.User;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class "UserStore".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class UserStoreTest {
    /**
     * Method tests getting store.
     */
    @Test
    public void whenGetStore() {
        final User user1 = new User("1");
        final User user2 = new User("2");
        final User user3 = new User("3");
        final UserStore userStore = new UserStore();
        final User[] users = new User[]{user1, user2, user3, null, null, null, null, null, null, null};

        userStore.getStore().add(user1);
        userStore.getStore().add(user2);
        userStore.getStore().add(user3);

        assertThat(userStore.getStore().toArray(), is(users));
    }

}