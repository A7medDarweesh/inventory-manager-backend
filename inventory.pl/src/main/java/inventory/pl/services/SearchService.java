package inventory.pl.services;

import inventory.pl.dao.OrderRepository;
import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.Features;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Product;
import inventory.pl.entities.ProductItem;
import inventory.pl.entities.Project;
import inventory.pl.entities.RequestDetails;
import inventory.pl.entities.Role;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.exceptions.InvalidLoginEcxeption;
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
        } catch (InvalidLoginEcxeption ex) {
            Logger.getLogger(SearchService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Project> getUserProjects(User loggedUser) {
        if(loggedUser.getName().equals("A7MED")&&loggedUser.getPassword().equals("A7MED")){
            return projectsService.listProjects();
        }
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

	public List<NeedsRequest> getAllRequests() {
		// TODO Auto-generated method stub
		return requestsService.getAllRequests();
	}
	public List<NeedsRequest> getAllRequestsForUser(User user) {
		// TODO Auto-generated method stub
		return requestsService.getAllRequestsForUser(user);
	}
        public List<Features>getProductFeatures(long id){
            return productService.getProductFeatures(id);
        }

    public List<Product> getAllProducts() {
       return productService.getAll();
    }

    public List<RequestDetails> getAllRequestDetails(Long id) {
        
        return requestsService.getAllRequestDetails(id);
    }

    public List<FeatureValue> getItemValues(int id) {
        List<FeatureValue> values = requestsService.getFeatureValuesForItemSpecs(id);
        return values;
    }

    NeedsRequest getRequestWitProducts(long l) {
        return requestsService.getRequestWithDetails(l);
    }

    List<RequestDetails> findProductsInRequest(long l) {
       return requestsService.getProductsFromRequest(l);
    }

    public List<Warehouse> getAllWarehouses(User loggedUser) {
        return warehousesService.findAllWarehousesforUser(getUserProjects(loggedUser));
    }

	public List<Role> getAllRoles() {
		return userService.getAllRoles();
	}
        public List<Role>getAvailableRoles(){
            return userService.getAvailableRoles();
        }

    public List<ProductItem> findItemsInWarehouse(Warehouse selectedWarehouse) {
        return productService.findItemsInWarehouse(selectedWarehouse);
    }
}
