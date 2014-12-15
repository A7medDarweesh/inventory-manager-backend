/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.dao;

/**
 *
 * @author ahmed_darweeesh
 * @param <T> the entity class
 */
public interface BaseDAO <T>{
    public void persist(T entity);
    T findById(long id);
    void delete(T entity);
    void updata(T entity);
}
