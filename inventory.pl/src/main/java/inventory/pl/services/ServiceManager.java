/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.services.product.ProductService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ahmed_darweeesh
 */

public class ServiceManager implements BaseServiceManager,Serializable{
    
    @Autowired
    BuyOrderService buyOrderSrervice;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    WarehousesService warehousesService;
    @Autowired
    SearchService searchService;
    @Autowired
    SaveService saveService;

   
    @Override
    public BuyOrderService getBuyOrderSrervice() {
        return buyOrderSrervice;
    }

    @Override
    public ProductService getProductService() {
        return productService;
    }

    @Override
    public WarehousesService getwWarehousesService() {
        return warehousesService;
    }

    public SearchService getSearchService() {
        return searchService;
    }

    public SaveService getSaveService() {
        return saveService;
    }
    
    
}
