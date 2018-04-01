package cn.xiao.controller;

import cn.xiao.entity.SimpBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 * Created by Smile on 2018/4/1.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String hello(Model model) {
        return "Index Page! ";
    }

    @RequestMapping("/abc")
    @ResponseBody
    public String abc(Model model) {
        return "Home Page abc!";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        return "pages/home";
    }
}
