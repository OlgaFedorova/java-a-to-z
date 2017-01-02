package ofedorova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ofedorova.DataBase.NullUserOfDB;
import ofedorova.prototype.User;
import ofedorova.prototype.UserFactory;

/**
 * The class implements a repository for gamers.
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public class Repository {

    /**
     * List of gamers.
     */
    private final List<User> users = new ArrayList<>();
    /**
     * Factory for creating of new user.
     */
    private final UserFactory userFactory;

    /**
     * Allocates a new {@code Repository}
     *
     * @param userFactory value for field "userFactory"
     */
    public Repository(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    /**
     * Method creates a new user.
     *
     * @param name of new user
     * @param age of new user
     * @return true - if new user is creating, false - if new user isn't
     * creating.
     */
    public boolean create(String name, String age) {
        boolean isCreate = false;
        if (this.isNameUnique(name)) {
            User user = this.userFactory.getNewUser(name, age);
            if (!user.isNull()) {
                this.users.add(user);
                isCreate = true;
            }
        }
        return isCreate;
    }

    /**
     * Method finds a user by "id" and sets new values of fields "name", "age".
     *
     * @param id value of identifier editable user
     * @param name value of new name editable user
     * @param age value of new age editable user
     * @return true - if user is editing, false - if user isn't editing.
     */
    public boolean edit(String id, String name, String age) {
        boolean isEdit = false;
        User user = this.findById(id);
        if (!user.isNull()) {
            if (user.getName() != null && !user.getName().isEmpty() && (user.getName().equals(name) || this.isNameUnique(name))) {
                user.edit(name, age);
                isEdit = true;
            }
        }
        return isEdit;
    }

    /**
     * Method removes user from repository.
     *
     * @param id value of identifier removing user
     * @return true - if user is removing, false - if user isn't removing.
     */
    public boolean remove(String id) {
        User user = this.findById(id);
        if(!user.isNull()){
            this.userFactory.removeUser(user);
        }
        return this.users.remove(user);
    }
    
    /**
     * Getter for field "gamers"
     *
     * @return list of gamers
     */
    public List<User> getUsers() {
        return Collections.unmodifiableList(this.users);
    }

    /**
     * Method finds a user by value of identifier.
     *
     * @param id value of identifier
     * @return true - if user is finding, false - if user isn't finding.
     */
    private User findById(String id) {
        User result = new NullUserOfDB();
        for (User user : this.users) {
            if (user.getId().equals(id)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Method checks unique value of name for user.
     *
     * @param name
     * @return true - if name is unique, false - if name isn't unique.
     */
    private boolean isNameUnique(String name) {
        boolean isUnique = true;
        for (User user : this.users) {
            if (user.getName().equals(name)) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

}
