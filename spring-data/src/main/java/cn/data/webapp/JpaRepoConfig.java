package cn.data.webapp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by Smile on 2018/4/3.
 */

@Configuration
@EnableJpaRepositories(basePackages="cn.data.dao")
public class JpaRepoConfig {
    /**
     * C3P0数据源
     */
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/studydb?characterEncoding=utf8");
        ds.setUser("root");
        ds.setPassword("smile#2002");
        ds.setMaxPoolSize(10);
        ds.setMinPoolSize(1);
        ds.setInitialPoolSize(2);
        ds.setMaxIdleTime(20);
        ds.setAcquireIncrement(3);
        ds.setIdleConnectionTestPeriod(60);
        ds.setUnreturnedConnectionTimeout(190);
        ds.setCheckoutTimeout(20000);
        ds.setAcquireRetryAttempts(30);
        return ds;
    }


    /**
     * Hibernate Session Factory Bean
     * 须放在root上下文中，否则其他组件（如 OpenSessionInViewFilter）找不到该 Bean
     */
    @Bean(name="sessionFactory")
    public AnnotationSessionFactoryBean sessionFactory(DataSource dataSource) {
        AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "cn.hiber.domain" });
        Properties props = new Properties();
        props.setProperty("dialecct", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "false");
        props.setProperty("hibernate.cache.use_second_level_cache", "false");
        props.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
        //props.setProperty("hibernate.current_session_context_class", "thread");
        sessionFactory.setHibernateProperties(props);
        return sessionFactory;
    }
}
