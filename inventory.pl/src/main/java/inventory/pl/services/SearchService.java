package inventory.pl.services;

import inventory.pl.entities.User;
import inventory.pl.exceptions.InvaliDloginEcxeption;
import inventory.pl.services.product.ProductService;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
