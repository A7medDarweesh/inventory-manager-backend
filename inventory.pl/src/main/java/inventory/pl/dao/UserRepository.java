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
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ahmed_darweeesh
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User>findAllByName(String name);
    public List<User>findAllByRole(Role role);
    public User findByNameAndPassword(String name,String password);
    @Query("Select u from User u Join Fetch u.projects where u.id=:id")
    public User getUserWithProjects(@Param("id")Integer id);
    
}
