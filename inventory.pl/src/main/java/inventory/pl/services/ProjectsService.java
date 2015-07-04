/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import inventory.pl.dao.ProjectRepository;
import inventory.pl.entities.Project;
import inventory.pl.entities.User;
import inventory.pl.entities.Warehouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed_darweeesh
 */
@Transactional
@Service
public class ProjectsService {
    @Autowired
    ProjectRepository repository;
    public ProjectsService() {
    }
    public void save(Project p){
        repository.save(p);
    }
    public Project findProject(long id){
        return repository.findOne(id);
    }
    public List<Project>listProjects(){
        return repository.findAll();
    }
    public void updateProjectUsersList(Project project,List<User>users){
    	project.setUsers(users);
    	repository.save(project);
    }

    List<Warehouse> findAllWarehousesforUser(User loggedUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
