/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.RequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ahmed_darweeesh
 */
public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Long>{
    
}
