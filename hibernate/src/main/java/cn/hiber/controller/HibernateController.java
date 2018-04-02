package cn.hiber.controller;

import cn.hiber.dao.UserDao;
import cn.hiber.domain.User;
import cn.hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HibernateController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/demo1")
    public String demo1(Model model) {
        User user = userDao.getUserById(166);
        model.addAttribute("user", user);
        return "pages/demo1";
    }
}
