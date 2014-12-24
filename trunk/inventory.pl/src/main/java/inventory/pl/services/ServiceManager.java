/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ahmed_darweeesh
 */

public class ServiceManager implements BaseServiceManager{
    
    @Autowired
    BuyOrderService buyOrderSrervice;
    @Autowired
    ProductService productService;

   
    @Override
    public BuyOrderService getBuyOrderSrervice() {
        return buyOrderSrervice;
    }

    @Override
    public ProductService getProductService() {
        return productService;
    }
    
    
}
