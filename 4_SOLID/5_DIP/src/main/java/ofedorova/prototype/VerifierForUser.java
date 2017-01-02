package ofedorova.prototype;

/**
 * The interface implements verifier for checking field of class "User".
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public interface VerifierForUser {

    /**
     * The method checks new value of field "id".
     *
     * @param id new value of field "id"
     * @return true - if value is correct, false - if value isn't correct.
     */
    boolean checkId(String id);

    /**
     * The method checks new value of field "name".
     *
     * @param name new value of field "name"
     * @return true - if value is correct, false - if value isn't correct.
     */
    boolean checkName(String name);

    /**
     * The method checks new value of field "age".
     *
     * @param age new value of field "age"
     * @return true - if value is correct, false - if value isn't correct.
     */
    boolean checkAge(String age);

}
