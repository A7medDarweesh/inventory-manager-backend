/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services;

import inventory.pl.entities.BuyOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed_darweeesh
 */
@Service
public class BuyOrderServiceImpl implements BuyOrderService {

//    @Autowired
//    SessionFactory sessionFactory;

    @Transactional
    public void save(BuyOrder entity) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(entity);
    }

}
