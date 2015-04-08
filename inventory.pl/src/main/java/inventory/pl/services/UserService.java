/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.RoleRepostiroy;
import inventory.pl.dao.UserRepository;
import inventory.pl.entities.Role;
import inventory.pl.entities.User;
import inventory.pl.exceptions.InvaliDloginEcxeption;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed_darweeesh
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepostiroy roleRepostiroy;
    public void addUser(User u){
        userRepository.save(u);
    }
    public void addRole(Role r){
        roleRepostiroy.save(r);
    }
    public List<User>getAllUsersInRole(long roleID){
        Role role=roleRepostiroy.findOne(roleID);
        System.out.println("role name="+role.getRoleName());
        List<User>users=role.getUsers();
        System.out.println(users.size());
        return users;
    }
    public Role getRoleByID(long id){
        return roleRepostiroy.findOne(id);
    }

    public void removeDuplicateNames(String name) {
        List<User>users=userRepository.findAllByName(name);
        for(int i=1;i<users.size();i++){
            userRepository.delete(users.get(i));
        }
    }
    public User login(String name,String password) throws InvaliDloginEcxeption{
    	User loggingUser=userRepository.findByNameAndPassword(name, password);
    	if(loggingUser==null){
    		throw new InvaliDloginEcxeption("User name or password is wrong");
    	}
    	return loggingUser;
    }
}
