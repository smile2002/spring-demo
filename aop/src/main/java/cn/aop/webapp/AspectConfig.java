package cn.aop.webapp;

import cn.aop.aspect.MyUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Smile on 2018/4/4.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"cn.aop.aspect"})
public class AspectConfig {
    @Bean
    public MyUtil myUtil() {
        return new MyUtil();
    }
}
