/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ahmed_darweeesh
 */
public interface OrderRepository extends JpaRepository<NeedsRequest, Long> {
	 @Query("select n from NeedsRequest n where n.project in(?1)")
	    List<NeedsRequest> getRequestsByProject(Project[]projects);
    
}
