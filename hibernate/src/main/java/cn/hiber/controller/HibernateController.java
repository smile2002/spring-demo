package cn.hiber.controller;

import cn.hiber.dao.UserDao;
import cn.hiber.domain.User;
import cn.hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HibernateController {

    @Autowired
    UserDao userDao;

    /**
     * session.get()
     */
    @RequestMapping("/demo1")
    public String demo1(Model model) {
        User user = userDao.getUserById(166);
        model.addAttribute("user", user);
        return "pages/demo1";
    }

    /**
     * session.createQuery(sql)
     * sessino.list()
     */
    @RequestMapping("/demo2")
    public String demo2(Model model) {
        List<User> users = userDao.getUserById2(166);
        model.addAttribute("title", "user demo 2");
        model.addAttribute("users", users);
        return "pages/demos";
    }

    /**
     * session.createCriteria();
     * criteria.list()
     */
    @RequestMapping("/demo3")
    public String demo3(Model model) {
        List<User> users = userDao.getUserById3(166);
        model.addAttribute("title", "user demo 3");
        model.addAttribute("users", users);
        return "pages/demos";
    }
}
