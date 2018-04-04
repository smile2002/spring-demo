package cn.mb.dao;

import cn.mb.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by Smile on 2018/4/3.
 */
public interface UserMapper {
    public User check(@Param("username") String username, @Param("password") String password);
    public User getUser(@Param("userId") String userId);

    @Select("select * from users where id = #{id}")
    User selectUserById2(Integer id);


    /*@Results(id = "userResult", value = {
            @Result(property = "id", column = "uid", id = true),
            @Result(property = "age", column = "age"),
            @Result(property = "name", column = "name")
    })
    @Select("select * from users where id = #{id}")
    User getUserById3(Integer id);*/

    @Insert("insert into user (age, name) values (#{age}, #{name})")
    int insertUser(int age, String name);
}