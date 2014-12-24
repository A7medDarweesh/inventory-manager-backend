/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services.product;

import inventory.pl.dao.ProductRepository;
import inventory.pl.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahmed_darweeesh
 */
@Service
public class ProductService {

    @Autowired
    @Qualifier("baseIMPL")
    ProductDAO productDAO;
    @Autowired
    ProductRepository repository;

    public void saveProduct(Product p) {
        //productDAO.addProduct(p);
        repository.save(p);
    }
    public List<Product> getProductNameLike(String likeName){
        return repository.findByNameLikeOrderByCreateDateDesc(likeName);
    }
    public Product getByName(String name){
        return repository.getProductByName(name);
    }
    public void removeDuplicateNames(String name){
        List<Product>products=repository.getProductsByName(name);
        for(int i=1;i<products.size();i++){
            repository.delete(products.get(i));
        }
    }
}
