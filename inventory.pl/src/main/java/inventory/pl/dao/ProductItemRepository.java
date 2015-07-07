/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.ProductItem;
import inventory.pl.entities.Warehouse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ahmed_darweeesh
 */
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{
    public ProductItem findById(long id);
    public List<ProductItem> findByWarehouse(Warehouse warehouse);
    
}
