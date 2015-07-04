/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.RequestDetails;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ahmed_darweeesh
 */
public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Integer>{
    @Query("select n from RequestDetails n where n.id in :ids")
	    List<RequestDetails> getRequestDetailsInIds(@Param("ids") Set<Integer>ids);
}
