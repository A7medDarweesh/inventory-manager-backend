package inventory.pl.services.product;

import inventory.pl.entities.Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductDAOImpl implements ProductDAO {
	  @PersistenceContext
	    private EntityManager entityManager;

	@Override
	public Product findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCriteria(CriteriaQuery<Product> criteriaQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	

}
