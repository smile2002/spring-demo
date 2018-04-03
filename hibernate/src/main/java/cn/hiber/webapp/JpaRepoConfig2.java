package cn.hiber.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"cn.hiber.dao"})
/** @EnableJpaRepositories 等价于 <jpa:repository> 元素
 *  需要配置 transactionManagerRef 及 entityManagerFactoryRef
 *  如果这两个 Bean 的 Id 与注解提供的缺省值相同，可以省略配置
 */
public class JpaRepoConfig2 {

}
