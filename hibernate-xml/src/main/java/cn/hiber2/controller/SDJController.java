package cn.hiber2.controller;

import cn.hiber2.dao.UserRepository;
import cn.hiber2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Smile on 2018/4/3.
 */
@Controller
public class SDJController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/sdj")
    public String sdj(Model model) {
        User user  = userRepository.getUserById(168);
        model.addAttribute("user", user);
        return "pages/demo1";
    }
}
