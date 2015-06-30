/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import java.util.List;

import inventory.pl.dao.OrderRepository;
import inventory.pl.dao.ProductItemRepository;
import inventory.pl.dao.RequestDetailsRepository;
import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.ProductItemSpecs;
import inventory.pl.entities.Project;
import inventory.pl.entities.RequestDetails;
import inventory.pl.entities.User;

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
    OrderRepository requestsRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    
    public void saveRequest(NeedsRequest request){
        requestsRepository.save(request);
    }
    public void saveDetail(RequestDetails details){
        detailsRepository.save(details);
    }
	public List<NeedsRequest> getAllRequests() {
		// TODO Auto-generated method stub
		return requestsRepository.findAll();
	}
	public List<NeedsRequest> getAllRequestsForUser(User user) {
		// TODO Auto-generated method stub
		return requestsRepository.getRequestsByProject((Project[])user.getProjects().toArray());
	}

    List<RequestDetails> getAllRequestDetails(Long id) {
        NeedsRequest request=requestsRepository.findOne(id);
        for(RequestDetails detai:request.getProductList()){
            detai.getRequestItems().getFeaturesValues();
        }
        return request.getProductList();
    }

    public List<FeatureValue> getFeatureValuesForItemSpecs(int id) {
        RequestDetails details=detailsRepository.findOne(id);
        List<FeatureValue> values = details.getRequestItems().getFeaturesValues();
        return values;
    }
}
