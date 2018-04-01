package cn.xiao.controller;

import cn.xiao.entity.User;
import cn.xiao.entity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Smile on 2018/4/1.
 */
@Controller
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping("jdbc")
    public String jdbc(Model model) {
        String SQL = "select * from User";
        // 生成 Mapper ：
        // 1. 手动编写
        // 2. RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> userList = jdbcTemplate.query(SQL, new UserMapper());
        User user;
        System.out.println("UserList: " + userList.size());
        model.addAttribute("Users", userList);
        return "pages/jdbc";
    }

    private User select_demo(String userId) {
        String SQL = "select * from User where userId = ?";
        User user = jdbcTemplate.queryForObject(SQL, new UserMapper(), userId);
        // 其他写法：
        // User user = jdbcTemplate.queryForObject(SQL, new Object[]{userId}, new UserMapper());
        return user;
    }
    private void insert_demo(String userId, String name) {
        String SQL = "insert into User(userId, name) values (?, ?)";
        jdbcTemplate.update(SQL, userId, name);
    }
    private void update_demo(String userId, String name) {
        String SQL = "update User set name = ? where userId = ?";
        jdbcTemplate.update(SQL, name, userId);
    }

    private void delete_demo(String userId) {
        String SQL = "delete from  User where userId = ?";
        jdbcTemplate.update(SQL, userId);
    }

    /**
     * 具名参数方式1
     */
    private void named_insert_demo_1()
    {
        String sql = "INSERT INTO user VALUES(:userId, :name, :age)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userId", "181729387192");
        paramMap.put("name", "elle");
        paramMap.put("age", 30);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 具名参数方式2
     */
    private void named_insert_demo_2()
    {
        String sql = "INSERT INTO user VALUES(:userId, :name, :age)";
        User user = new User();
        user.setUserId("19874837844");
        user.setName("lock");
        user.setAge(28);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }
}
