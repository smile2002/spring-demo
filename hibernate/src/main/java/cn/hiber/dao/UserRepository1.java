package cn.hiber.dao;

import cn.hiber.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * 不推荐这种模式，样板代码多
 * EntityManager 线程不安全，每次创建新的 EntityManager 实例
 */
@Repository
public class UserRepository1 {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Transactional
    public User getUserById(int id) {
        return emf.createEntityManager().find(User.class, id);
    }
}
