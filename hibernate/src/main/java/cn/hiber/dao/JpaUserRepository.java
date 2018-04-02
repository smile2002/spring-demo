package cn.hiber.dao;

import cn.hiber.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by Smile on 2018/4/2.
 */
@Repository
public class JpaUserRepository {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Transactional
    public User getUserById(int id) {
        return emf.createEntityManager().find(User.class, id);
    }
}
