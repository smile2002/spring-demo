package cn.mb.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.util.Properties;

/**
 * Created by Smile on 2018/4/3.
 */

@Configuration
@EnableWebMvc
@ComponentScan("cn.mb.controller")
public class ServletConfig extends WebMvcConfigurationSupport {

    @Bean
    public VelocityConfigurer velocityConfigurer() {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("views");
        Properties props = new Properties();
        props.put("file.resource.loader.cache", true);
        props.put("file.resource.loader.modificationCheckInterval", "2");
        props.put("input.encoding", "UTF-8");
        props.put("output.encoding", "UTF-8");
        props.put("contentType", "text/html;charset=UTF-8");
        velocityConfigurer.setVelocityProperties(props);
        return velocityConfigurer;
    }
    @Bean
    public VelocityLayoutViewResolver viewResolver() {
        VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
        viewResolver.setCache(false);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".vm");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setExposeRequestAttributes(true);
        viewResolver.setExposeSessionAttributes(true);
        viewResolver.setAllowSessionOverride(true);
        viewResolver.setAllowRequestOverride(true);
        viewResolver.setRequestContextAttribute("rc");
        viewResolver.setLayoutUrl("layout/default.vm");
        return viewResolver;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
    }
}
