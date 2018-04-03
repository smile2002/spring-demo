package cn.hiber.controller;

import cn.hiber.dao.UserRepository3;
import cn.hiber.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/3.
 */
@Controller
public class Jpa3Controller {
    @Autowired
    UserRepository3 userRepository;

    @RequestMapping("/jpa3")
    public String jpa2(Model model) {
        User user  = userRepository.getUserById(168);
        model.addAttribute("user", user);
        return "pages/demo1";
    }
}