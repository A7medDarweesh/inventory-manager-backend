/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services.product;

import inventory.pl.dao.ProductItemRepository;
import inventory.pl.dao.ProductRepository;
import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.Features;
import inventory.pl.entities.Product;
import inventory.pl.entities.ProductItems;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed_darweeesh
 */
@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductItemRepository itemsRepository;

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
    public List<Product>getAll(){
        return repository.findAll();
    }
    public void saveProductItem(ProductItems item){
        itemsRepository.save(item);
    }
    public List<Features>getProductFeatures(long id){
        Product p=repository.findOne(id);
        List<Features>fets=p.getProductFeatures();
        System.out.println("size="+fets.size());
        return fets;
    }
    public List<ProductItems>getProductItems(long id){
        Product p=repository.findOne(id);
        List<ProductItems>items=p.getProductItems();
        System.out.println(""+items.size());
        return items;
    }
    public List<FeatureValue> getItemValues(long id){
        ProductItems item=itemsRepository.findOne(id);
        List<FeatureValue>vals=item.getFeaturesValues();
        vals.size();
        return vals;
    }
}
