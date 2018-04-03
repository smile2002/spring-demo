package cn.hiber.controller;

import cn.hiber.dao.UserRepository2;
import cn.hiber.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018
 */
@Controller
public class Jpa2Controller {

    @Autowired
    UserRepository2 userRepositiry;

    @RequestMapping("/jpa2")
    public String jpa2(Model model) {
        User user  = userRepositiry.getUserById(167);
        model.addAttribute("user", user);
        return "pages/demo1";
    }
}
