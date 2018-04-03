package cn.data.controller;

import cn.data.dao.UserRepository;
import cn.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/3.
 */
@Controller
public class JpaController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/jpa")
    public String jpa(Model model) {
        User user = userRepository.getUserById(168);
        model.addAttribute("user", user);
        return "pages/jpa";
    }
}
