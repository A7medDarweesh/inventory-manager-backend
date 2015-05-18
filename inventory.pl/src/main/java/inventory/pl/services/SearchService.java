package inventory.pl.services;

import inventory.pl.entities.Project;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.exceptions.InvaliDloginEcxeption;
import inventory.pl.services.product.ProductService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SearchService {

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
    EntityManager em;
    public User getUser(int id){
        return userService.getUser(id);
    }

    public User login(String userName,String password) {
        try {
            return userService.login(userName, password);
        } catch (InvaliDloginEcxeption ex) {
            Logger.getLogger(SearchService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Project> getUserProjects(User loggedUser) {
       return userService.getUserProjects(loggedUser);
    }

    public Object getObjectById(Class aClass, Object value) {
        System.out.println("gettin object for class"+aClass);
        Object obj = em.find(aClass, value);
        System.out.println("object ="+obj);
        return obj;
    }

    public List<User> getAllusers() {
        return userService.getAllUsers();
    }

}
