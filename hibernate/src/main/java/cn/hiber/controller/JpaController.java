package cn.hiber.controller;

import cn.hiber.dao.JpaUserRepository;
import cn.hiber.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/2.
 */
@Controller
public class JpaController {

    @Autowired
    JpaUserRepository jpaUserRepository;

    @RequestMapping("jpa")
    public String jpa(Model model) {
        User user = jpaUserRepository.getUserById(166);
        model.addAttribute("user", user);
        return "pages/jpa";
    }
}
