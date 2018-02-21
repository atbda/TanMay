/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sony.daoimpl;

import com.sony.dao.UserDao;
import com.sony.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shahrukh
 */

@Repository(value = "udao")
public class UserDaoIMpl implements UserDao{

    @Autowired
    SessionFactory sessionFactory;
    
    
    @Override
    public void save(User u) {
    
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
    
    
    }
    
}
