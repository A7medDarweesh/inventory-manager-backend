/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.Product;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ahmed_darweeesh
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCreateDate(Date d);
    List<Product> findByNameLikeOrderByCreateDateDesc(String name);
    @Query("select p from Product p where p.name=?1")
    Product getProductByName(String name);
    @Query("select p from Product p where p.name=?1")
    List<Product> getProductsByName(String name);
}
