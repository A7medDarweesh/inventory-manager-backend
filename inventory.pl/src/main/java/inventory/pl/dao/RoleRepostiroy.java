/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

import inventory.pl.entities.Role;
import inventory.pl.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ahmed_darweeesh
 */
public interface RoleRepostiroy extends JpaRepository<Role, Long>{
    @Query("SELECT p FROM Role p JOIN FETCH p.users WHERE p.id = ?1")
    public Role findByIdAndFetchRolesEagerly(long id);
    @Query("SELECT p FROM Role p JOIN FETCH p.users")
    public List<Role> findAllAndFetchRolesEagerly();
}
