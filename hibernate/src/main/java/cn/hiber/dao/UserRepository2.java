package cn.hiber.dao;

import cn.hiber.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Smile on 2018/4/3.
 */
@Repository
public class UserRepository2 {
    @PersistenceContext
    private EntityManager em;

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public void addUser(User user) {
        em.persist(user);
    }

    public void saveUser(User user) {
        em.merge(user);
    }
}
