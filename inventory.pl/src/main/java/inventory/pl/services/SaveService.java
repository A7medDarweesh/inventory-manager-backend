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
import inventory.pl.services.product.ProductService;

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
	public void createProject(Project project){
		projectsService.save(project);
	}
	public void createProject(Project project,List<User>users){
		projectsService.save(project);
		updateProjectUserList(project, users);
	}
	public void updateProjectUserList(Project project,List<User>users){
		project.setUsers(users);
		projectsService.save(project);
	}
	public void addProduct(Product product){
		productService.saveProduct(product);
	}
	public void createProject(Project p,Warehouse warehouse){
		warehousesService.saveWarehouse(warehouse);
		p.getWarehouses().add(warehouse);
		projectsService.save(p);
	}
	public void createProject(Project p,Warehouse[] warehouse){
		p.getWarehouses().addAll(Arrays.asList(warehouse));
		projectsService.save(p);
	}
	public void addRequest(NeedsRequest request,List<RequestDetails>requestDetails){
		request.setProductList(requestDetails);
                requestDetails.stream().map((detail) -> {
                detail.setRequest(request);
                return detail;
            }).forEach((detail) -> {
                productService.saveProductItemSpecs(detail.getRequestItems());
            });
		requestsService.saveRequest(request);
	}
	
}
