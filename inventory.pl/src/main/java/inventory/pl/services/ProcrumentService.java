/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.ProcurmentRepository;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.Product;
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
    ProcurmentRepository repository;
    public void saveProcurement(Procurement p){
        repository.save(p);
    }
}
