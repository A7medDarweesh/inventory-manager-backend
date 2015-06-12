/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services;

import inventory.pl.configs.JPAConfig;
import inventory.pl.entities.User;
import inventory.pl.exceptions.InvalidLoginEcxeption;
import inventory.pl.helpers.Encryptor;
import inventory.pl.services.product.ProductService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author ahmed_darweeesh
 */
@Component
public class InventoryOperationsTest {

    
    RequestsService requestsService;
    
    ProjectsService projectsService;
    
    ProductService productService;
    
    UserService service;
    
    WarehousesService warehousesService;
    
    UserService userService;
    
    Encryptor encryptor;

    public InventoryOperationsTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
        encryptor=ctx.getBean(Encryptor.class);
        userService=ctx.getBean(UserService.class);
    }

    @After
    public void tearDown() {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testEncryption() {
        String out = encryptor.encrypt("A7med77", true);
        System.out.println("out=" + out);
         String out2 = encryptor.encrypt("A7med77", false);
        System.out.println("out2=" + out2);
        assertNotSame(out, out2);

    }
 @Test
    public void testCreateUser() {
        User testUser=new User();
        testUser.setJoinDate(new Date());
        testUser.setName("loli");
        testUser.setPassword(encryptor.encrypt("123!@#", true));
        testUser.setRole(userService.getRoleByID(1));
        userService.addUser(testUser);
        assertEquals(testUser.getId(), new Integer(4));

    }
     @Test
    public void testLogin() {
        User testUser = null;
        try {
            testUser = userService.login("loli", "123!@#");
        } catch (InvalidLoginEcxeption ex) {
            Logger.getLogger(InventoryOperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         assertNotNull(testUser);
        assertEquals(testUser.getId(), new Integer(18));

    }
}
