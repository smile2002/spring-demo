package cn.hiber2.controller;

import cn.hiber2.dao.UserDao;
import cn.hiber2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/2.
 */
@Controller
public class MainController {

    @Autowired
    UserDao userDao;

    @RequestMapping
    public String demo1(Model model) {
        User user = userDao.getUserById(166);
        model.addAttribute("user", user);
        return "pages/demo1";
    }
}
