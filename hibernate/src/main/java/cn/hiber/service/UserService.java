package cn.hiber.service;

import cn.hiber.domain.User;
import org.hibernate.Session;
/** For Hibernate3:
 * import org.hibernate.classic.Session;
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Smile on 2018/4/2.
 */

@Service
public class UserService {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public User getUserById(int id) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }
}
