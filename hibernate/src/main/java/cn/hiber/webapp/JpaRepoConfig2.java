package cn.hiber.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="cn.hiber")
public interface JpaRepoConfig2 {

}
