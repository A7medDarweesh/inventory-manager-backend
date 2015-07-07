/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ahmed_darweeesh
 */
public interface ProcurmentRepository extends JpaRepository<Procurement,Long>{
     @Query("select n from Procurement n where n.project in :projects")
	    List<Procurement> getRequestsByProject(@Param("projects") List<Project>projects);
            @Query("select n from Procurement n JOIN FETCH n.procrumentProducts where n.id=?1")
	    Procurement getRequestsWithDetails(long id);
}
