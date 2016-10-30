package ofedorova;

import ofedorova.DataBase.UserOfDB;
import ofedorova.DataBase.UserOfDBFactory;
import ofedorova.prototype.User;
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
    
    @Test
    public void testCreateUserTrue(){
        final User user = new UserOfDB("1000000", "user", "18");
        final boolean isCreate = repository.create("user", "18");
        assertTrue(isCreate && user.equals(repository.getUsers().get(0)));      
    }
    
    @Test
    public void testCreateUserFalse(){
        repository.create("user", "18");
        assertFalse(repository.create("user", "28"));      
    }
    
    @Test
    public void testEditUserTrue(){
        final User user = new UserOfDB("1000000", "userNew", "28");
        repository.create("user", "18");
        boolean isEdit = repository.edit("1000000", "userNew", "28");
        assertTrue(isEdit && user.equals(repository.getUsers().get(0)));      
    }
    
    @Test
    public void testEditUserFalse(){
        repository.create("user", "18");
        repository.create("userNew", "18");
        assertFalse(repository.edit("1000000", "userNew", "28"));      
    }
    
    @Test
    public void testRemoveUserTrue(){
        repository.create("user", "18");
        repository.create("userNew", "18");
        boolean isRemove = repository.remove("1000001");
        assertTrue(isRemove && repository.getUsers().size() == 1);      
    }
    
    @Test
    public void testRemoveUserFalse(){
        repository.create("user", "18");
        boolean isRemove = repository.remove("1000010");
        assertTrue(!isRemove && repository.getUsers().size() == 1);      
    }
    
    @Test
    public void testRemoveAndCreateUser(){
        final User user = new UserOfDB("1000001", "name", "26");
        
        repository.create("user", "18");
        repository.create("userNew", "18");
        repository.remove("1000001");
        boolean isCreate = repository.create("name", "26");
        
        assertTrue(isCreate && user.equals(repository.getUsers().get(1)));      
    }
}
