package cn.hiber2.dao;

import cn.hiber2.domain.User;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public User getUserById(int id) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        trans.commit();
        return user;
    }
}
