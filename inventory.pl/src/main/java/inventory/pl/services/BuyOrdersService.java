/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.OrderRepository;
import inventory.pl.dao.ProcurmentRepository;
import inventory.pl.dao.RequestDetailsRepository;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.RequestDetails;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed_darweeesh
 */
@Service
@Transactional
public class BuyOrdersService {
    @Autowired
    ProcurmentRepository orderRepository;
    @Autowired
    OrderRepository requestsrRepository;
    @Autowired
    RequestDetailsRepository detailsRepository;
    
    public void save(Procurement order,List<RequestDetails>products){
        Set<Integer>ids=new HashSet<>();
        products.stream().forEach((detail) -> {
            ids.add(detail.getId());
        });
        List<RequestDetails>productz=detailsRepository.getRequestDetailsInIds(ids);
        productz.stream().forEach((d) -> {
            d.setBuyOrder(order);
        });
        order.setProducts(productz);
        orderRepository.save(order);
//        for(RequestDetails detail:reqeust.getProductList()){
//            detail.
//        }
    }
}
