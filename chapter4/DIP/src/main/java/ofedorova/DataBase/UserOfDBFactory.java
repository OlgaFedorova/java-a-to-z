package ofedorova.DataBase;

import ofedorova.prototype.User;
import ofedorova.prototype.UserFactory;
import ofedorova.prototype.VerifierForUser;

/**
 * The class implements a factory for creating new user and creating verifier
 * for class "UserOFDB".
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public class UserOfDBFactory extends UserFactory {

    /**
     * Verifier for user
     */
    private VerifierForUserOfDB verifier;
    /**
     * Count of user
     */
    private int count;

    /**
     * Method creates new user.
     *
     * @param name value of name new user
     * @param age value of age new user
     * @return new user
     */
    @Override
    public User getNewUser(String name, String age) {
        String id = this.generateId();
        User user;
        if (id != null && !id.isEmpty()) {
            user = new UserOfDB(id, name, age);
        } else {
            user = new NullUserOfDB();
        }
        return user;
    }

    /**
     * Method compare count and id of user.
     *
     * @param user removing user
     */
    @Override
    public void removeUser(User user) {
        int numberOfId = 0;
        if (user.getId() != null && !user.getId().isEmpty()) {
            if (user.getId().matches("100000[1-9]")) {
                numberOfId = Integer.valueOf(user.getId().substring(6));
            } else if (user.getId().matches("10000[1-9]\\d")) {
                numberOfId = Integer.valueOf(user.getId().substring(5));
            } else if (user.getId().matches("1000[1-9]\\d{2}")) {
                numberOfId = Integer.valueOf(user.getId().substring(4));
            } else if (user.getId().matches("100[1-9]\\d{3}")) {
                numberOfId = Integer.valueOf(user.getId().substring(3));
            } else if (user.getId().matches("10[1-9]\\d{4}")) {
                numberOfId = Integer.valueOf(user.getId().substring(2));
            } else if (user.getId().matches("1[1-9]\\d[5]")) {
                numberOfId = Integer.valueOf(user.getId().substring(1));
            }
        }
        if (this.count == numberOfId + 1) {
            this.count--;
        }
    }

    /**
     * Method gets verifier for user.
     *
     * @return verifier for user.
     */
    @Override
    public VerifierForUser getVerifierForUser() {
        VerifierForUser result;
        if (this.verifier != null) {
            result = this.verifier;
        } else {
            result = new VerifierForUserOfDB();
        }
        return result;
    }

    /**
     * Method generate new identifier for user.
     *
     * @return new identifier
     */
    private String generateId() {
        String result;
        String valueForId = String.valueOf(this.count++);
        switch (valueForId.length()) {
            case 1:
                result = String.format("100000%s", valueForId);
                break;
            case 2:
                result = String.format("10000%s", valueForId);
                break;
            case 3:
                result = String.format("1000%s", valueForId);
                break;
            case 4:
                result = String.format("100%s", valueForId);
                break;
            case 5:
                result = String.format("10%s", valueForId);
                break;
            case 6:
                result = String.format("1%s", valueForId);
                break;
            default:
                result = new String();
        }
        return result;
    }

}
