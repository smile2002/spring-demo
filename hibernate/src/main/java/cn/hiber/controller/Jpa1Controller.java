package cn.hiber.controller;

import cn.hiber.dao.UserRepository1;
import cn.hiber.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/2.
 */
@Controller
public class Jpa1Controller {

    @Autowired
    UserRepository1 userRepository;

    @RequestMapping("jpa1")
    public String jpa1(Model model) {
        User user = userRepository.getUserById(166);
        model.addAttribute("user", user);
        return "pages/jpa";
    }
}
