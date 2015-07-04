/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.WarehouseRepository;
import inventory.pl.entities.Project;
import inventory.pl.entities.Warehouse;
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
public class WarehousesService {
    @Autowired
    WarehouseRepository repository;
    public void saveWarehouse(Warehouse warehouse){
        repository.save(warehouse);
    }
    public List<Warehouse>findAll(){
        return repository.findAll();
    }

    List<Warehouse> findAllWarehousesforUser(List<Project> userProjects) {
        Set<Project> ids=new HashSet<>();
        long l=0;
        for(Project p:userProjects){
            l=p.getId();
            ids.add(p);
        }
        return repository.getUserWarehouses(ids);
    }
}
