/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services;

import inventory.pl.configs.JPAConfig;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.Project;
import inventory.pl.entities.RequestDetails;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.exceptions.InvalidLoginEcxeption;
import inventory.pl.helpers.Encryptor;
import inventory.pl.helpers.RequestStatus;
import inventory.pl.services.product.ProductService;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ahmed_darweeesh
 */
@Component
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JPAConfig.class)
public class InventoryOperationsTest {

    @Autowired
    RequestsService requestsService;
    @Autowired
    ProjectsService projectsService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService service;
    @Autowired
    WarehousesService warehousesService;
    @Autowired
    UserService userService;
    @Autowired
    Encryptor encryptor;
    @Autowired
    SearchService searchService;
    @Autowired
    BuyOrdersService procService;

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
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
//        userService=ctx.getBean(UserService.class);
//        searchService=ctx.getBean(SearchService.class);
//        procService=ctx.getBean(BuyOrdersService.class);
        
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
    @Ignore
    @Test
    public void testAddProcurment(){
         User testUser = null;
        try {
            testUser = userService.login("loli", "123!@#");
        } catch (InvalidLoginEcxeption ex) {
            Logger.getLogger(InventoryOperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         assertNotNull(testUser);
        Project p=searchService.getUserProjects(testUser).get(0);
        Procurement proc=new Procurement();
        proc.setAddingDate(new Date());
        proc.setProject(p);
        proc.setRequestStatus(RequestStatus.UNDER_REVIEW);
       List<RequestDetails>products = searchService.findProductsInRequest(1l);
        procService.save(proc, products);
        assertEquals(proc.getId(), 16);
    }
    @Test
   public void testGetWarehouses(){
         User testUser = null;
        try {
            
            testUser = userService.login("loli", "123!@#");
        } catch (InvalidLoginEcxeption ex) {
            Logger.getLogger(InventoryOperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Warehouse> warehouses = searchService.getAllWarehouses(testUser);
        assertEquals(warehouses.size(), 1);
    }
}
