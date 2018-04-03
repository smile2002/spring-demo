package cn.mb.dao;

import cn.mb.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Smile on 2018/4/3.
 */
public interface UserMapper {
    public User check(@Param("username") String username, @Param("password") String password);
    public User getUser(@Param("userId") String userId);
}