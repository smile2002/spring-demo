package cn.hiber.dao;

import cn.hiber.domain.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


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
    @Transactional
    public List<User> getUserById2(int id) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("select id, age, name from user2 where id = ?");
        //query.setFirstResult(pageNum).setMaxResults(pageSize);
        return query.list();
    }
    @Transactional
    public List<User> getUserById3(int id) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Criterion criterion = Restrictions.eq("id", id);
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(criterion);
        return criteria.list();
    }

    /*
    public Long getUserCount() {
        Object count = hibernateTemplate.execute(new HibernateCallback<Long>() {
            public Long doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery("select * from user where id > ?");
                query.setParameter(0, 123);
                Long count = (Long)query.uniqueResult();
                return count;
            }
        });
        return (Long)count;
    }
    */
}
