package ofedorova.prototype;

/**
 * The abstract class implements a factory for creating new user and creating verifier
 * for user.
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public abstract class UserFactory {

    /**
     * Method creates new user.
     *
     * @param name value of name new user
     * @param age value of age new user
     * @return new user
     */
    public abstract User getNewUser(String name, String age);
    
    /**
     * Method can performs additional activities for removing user.
     * @param user removing user
     */
    public abstract void removeUser(User user);

    /**
     * Method gets verifier for user.
     *
     * @return verifier for user.
     */
    public abstract VerifierForUser getVerifierForUser();

}
