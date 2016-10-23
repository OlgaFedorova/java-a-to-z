package ofedorova.DataBase;

import ofedorova.prototype.VerifierForUser;

/**
 * The class verifier for checking field of class "UserOfDB".
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public class VerifierForUserOfDB implements VerifierForUser {

    /**
     * The method checks new value of field "id".
     *
     * @param id new value of field "id"
     * @return true - if value is correct, false - if value isn't correct.
     */
    @Override
    public boolean checkId(String id) {
        boolean isRight = false;
        if (id != null) {
            isRight = id.matches("1\\d{6}");
        }
        return isRight;
    }

    /**
     * The method checks new value of field "name".
     *
     * @param name new value of field "name"
     * @return true - if value is correct, false - if value isn't correct.
     */
    @Override
    public boolean checkName(String name) {
        boolean isRight = false;
        if (name != null) {
            isRight = name.matches("(\\w\\d){1,30}");
        }
        return isRight;
    }

    /**
     * The method checks new value of field "age".
     *
     * @param age new value of field "age"
     * @return true - if value is correct, false - if value isn't correct.
     */
    @Override
    public boolean checkAge(String age) {
        boolean isRight = false;
        if (age != null) {
            isRight = age.matches("[1-9]\\d");
        }
        return isRight;
    }

}
