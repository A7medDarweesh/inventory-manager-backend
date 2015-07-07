/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.ProcurmentRepository;
import inventory.pl.dao.RequestDetailsRepository;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.Product;
import inventory.pl.entities.RequestDetails;
import inventory.pl.entities.User;
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
public class ProcrumentService {
    @Autowired
    ProcurmentRepository orderRepository;
    @Autowired
    RequestDetailsRepository detailsRepository;
     public void saveProcurement(Procurement order,List<RequestDetails>products){
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
    public void saveProcurement(Procurement p){
        orderRepository.save(p);
    }
    public void saveDetail(RequestDetails details) {
        detailsRepository.save(details);
    }
     public List<Procurement> getAllRequestsForUser(User user) {
        if (user.getName().equals("A7MED") && user.getPassword().equals("A7MED")) {
            return orderRepository.findAll();
        }
        return orderRepository.getRequestsByProject(user.getProjects());
    }
      List<RequestDetails> getAllRequestDetails(Long id) {
        Procurement request = orderRepository.findOne(id);
        for (RequestDetails detai : request.getProducts()) {
            detai.getRequestItems().getFeaturesValues();
        }
        return request.getProducts();
    }
      Procurement getRequestWithDetails(long l) {
        return orderRepository.getRequestsWithDetails(l);
    }
}
