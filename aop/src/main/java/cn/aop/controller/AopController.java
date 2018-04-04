package cn.aop.controller;

import cn.aop.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Smile on 2018/4/4.
 */
@Controller
public class AopController {

    @Autowired
    SampleService sampleService;

    @RequestMapping("/aop")
    @ResponseBody
    public String aop(Model model) {
        sampleService.service("Creative");
        return "Done!";
    }
}
