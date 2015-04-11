/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.OrderRepository;
import inventory.pl.dao.ProductItemRepository;
import inventory.pl.dao.RequestDetailsRepository;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.RequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed_darweeesh
 */
@Transactional
@Service
public class RequestsService {
    @Autowired
    RequestDetailsRepository detailsRepository;
    @Autowired
    OrderRepository requestrRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    
    public void saveRequest(NeedsRequest request){
        requestrRepository.save(request);
    }
    public void saveDetail(RequestDetails details){
        detailsRepository.save(details);
    }
    
}
