package inventory.pl.services;

import java.util.Arrays;
import java.util.List;

import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Product;
import inventory.pl.entities.ProductItem;
import inventory.pl.entities.ProductItemSpecs;
import inventory.pl.entities.Project;
import inventory.pl.entities.RequestDetails;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;
import inventory.pl.helpers.RequestStatus;
import inventory.pl.services.product.ProductService;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SaveService {

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

    public void createProject(Project project) {
        projectsService.save(project);
    }

    public void createProject(Project project, List<User> users, Warehouse warehouse) {
        projectsService.save(project);
        project.setWarehouses(warehouse);
        updateProjectUserList(project, users);
    }

    public void updateProjectUserList(Project project, List<User> users) {
        project.setUsers(users);
        projectsService.save(project);
    }

    public void addProduct(Product product) {
        productService.saveProduct(product);
    }

    public void createProject(Project p, Warehouse warehouse) {
        warehousesService.saveWarehouse(warehouse);
        p.setWarehouses(warehouse);
        projectsService.save(p);
    }

    public void createProject(Project p, Warehouse[] warehouse) {
       
        projectsService.save(p);
    }

    public void addRequest(NeedsRequest request, List<RequestDetails> requestDetails) {
        if(requestDetails!=null){
        request.setProductList(requestDetails);
        for (RequestDetails detail : requestDetails) {
            detail.setRequest(request);
            productService.saveProductItemSpecs(detail.getRequestItems());
        }
        }
        requestsService.saveRequest(request);
    }

	public void addRequest(Project projectToAddRequestTo) {
		NeedsRequest request=new NeedsRequest();
		request.setProject(projectToAddRequestTo);
                request.setRequestDate(new Date());
                request.setStatus(RequestStatus.UNDER_REVIEW);
		requestsService.saveRequest(request);
		
	}

    public void createProject(Project project, List<User> users, String newProjectWarehouse) {
        projectsService.save(project);
        Warehouse warehouse=new Warehouse();
        warehouse.setName(newProjectWarehouse);
        warehouse.setProject(project);
        project.setWarehouses(warehouse);
        updateProjectUserList(project, users);
    }

}
