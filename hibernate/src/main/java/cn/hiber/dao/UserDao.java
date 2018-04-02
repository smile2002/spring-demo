package cn.hiber.dao;

import cn.hiber.domain.User;
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
        User user = (User) session.get(User.class, id);
        return user;
    }
}
