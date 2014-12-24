/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.services.product.ProductService;

/**
 *
 * @author ahmed_darweeesh
 */
public interface BaseServiceManager {
   BuyOrderService getBuyOrderSrervice();
    ProductService getProductService();
}
