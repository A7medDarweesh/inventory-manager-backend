package inventory.pl.services.product;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import inventory.pl.entities.Product;

public interface ProductDAO {
	public Product findByID(long id);
	public List<Product>findByCriteria(CriteriaQuery<Product>criteriaQuery);
	public void update(Product product);
	public void delete(Product product);
	public List<Product> listAll();
	public void addProduct(Product product);

}
