/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services;

import inventory.pl.dao.RoleRepostiroy;
import inventory.pl.dao.UserRepository;
import inventory.pl.entities.Project;
import inventory.pl.entities.Role;
import inventory.pl.entities.User;
import inventory.pl.exceptions.InvaliDloginEcxeption;
import inventory.pl.helpers.Encryptor;
import java.util.Arrays;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFutureCallback;

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
    @Autowired
    Encryptor encryptor;
    private ExecutorService executor;

    public void addUser(User u) {
        userRepository.save(u);
    }

    public void addRole(Role r) {
        roleRepostiroy.save(r);
    }

    public List<User> getAllUsersInRole(long roleID) {
        Role role = roleRepostiroy.findOne(roleID);
        System.out.println("role name=" + role.getRoleName());
        List<User> users = role.getUsers();
        System.out.println(users.size());
        return users;
    }

    public Role getRoleByID(long id) {
        return roleRepostiroy.findOne(id);
    }

    public void removeDuplicateNames(String name) {
        List<User> users = userRepository.findAllByName(name);
        for (int i = 1; i < users.size(); i++) {
            userRepository.delete(users.get(i));
        }
    }

    public User login(String name, String password) throws InvaliDloginEcxeption {
        User loggingUser = userRepository.findByNameAndPassword(name, encryptor.encrypt(password, true));
        if (loggingUser == null) {
            throw new InvaliDloginEcxeption("User name or password is wrong");
        }
        return loggingUser;
    }

    User getUser(int id) {
        return userRepository.findOne(id);
    }

    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    List<Project> getUserProjects(User loggedUser) {
        User u = userRepository.findOne(loggedUser.getId());
        System.out.println("n of projects=" + u.getProjects().size() + Arrays.toString(Thread.currentThread().getStackTrace()));
        return u.getProjects();
    }

    @Async
    public Future<String> asynctest() {
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            AsyncResult<String>async=new AsyncResult<>("testing");
            async.addCallback(new ListenableFutureCallback<String>() {

                @Override
                public void onSuccess(String result) {
                    System.out.println("finished exec eith code:"+result);
                }

                @Override
                public void onFailure(Throwable ex) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            return async;
        } catch (InterruptedException e) {
            //
        }

        return null;
    }
}
