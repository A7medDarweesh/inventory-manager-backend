package inventory.pl.services;

import java.util.List;

import inventory.pl.entities.Product;
import inventory.pl.entities.Project;
import inventory.pl.entities.User;
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
	
}
