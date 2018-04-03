package cn.hiber2.dao;

import cn.hiber2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by Smile on 2018/4/3.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int id);

    //Iterable<User> findAll();
}
