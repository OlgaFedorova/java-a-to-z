package ofedorova;

import ofedorova.DataBase.UserOfDBFactory;
import ofedorova.prototype.UserFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * The class is for testing repository for "UsersOfDB".
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public class RepositoryTestForUserOfDB {
    
    private Repository repository;
    private UserFactory factory;
    
    @Before
    public void init(){
        this.factory = new UserOfDBFactory();
        this.repository = new Repository(this.factory);
    }
   
    
}
