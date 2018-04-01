package cn.xiao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件运行时加载
 * Created by Smile on 2018/4/1.
 */
@Controller
@PropertySource("classpath:my.properties")
public class PropController {

    @Value("${keyroot}")
    public String prop1;

    /**
     * @PropertySource 注解方式读取
     */
    @RequestMapping("/prop1")
    public String prop1(Model model) {
        model.addAttribute("prop1", prop1);
        return "pages/prop1";
    }

    /**
     * Properties.load() 方式读取
     */
    @RequestMapping("/prop2")
    public String prop2(Model model) {
        Properties conf = getProperties("ins.properties", this.getClass());
        model.addAttribute("prop2", conf);
        return "pages/prop2";
    }

    public static Properties getProperties(String resource, Class<?> clazz) {
        ClassLoader loader = clazz == null ? null : clazz.getClassLoader();
        Properties props = new Properties();
        InputStream in = null;
        try {
            in = loader == null ? ClassLoader.getSystemResourceAsStream(resource):loader.getResourceAsStream(resource);
            props.load(in);
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error closing InputStream for resource: " + resource);
                }
            }
        }
    }
}
