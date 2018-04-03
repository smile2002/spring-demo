package cn.mb.controller;

import cn.mb.dao.UserMapper;
import cn.mb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/3.
 */
@Controller
public class MainController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/mybatis")
    public String mybatis(Model model) {
        User user = userMapper.getUser("18611112222");
        model.addAttribute("user", user);
        return "pages/demo1";
    }
}
