package cn.xiao.webapp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages={"cn.xiao"},
        excludeFilters={@Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {

    /**
     * Spring自带数据源
     *  1. DriverManageDataSource: 每次 getConnection() 都创建新的链接
     *  2. SimpleDriverDataSource: 每次返回新连接，直接使用JDBC驱动
     *  3. SingleConnecctionDataSource: 返回同一个连接
     */
    //@Bean
    public DriverManagerDataSource testDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("root");
        ds.setPassword("smile#2002");
        return ds;
    }

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
     * 一共三种JdbcTemplate
     *  1. JdbcTemplate: 基本JDBC模板
     *  2. NamedParameterJdbcTemplate: 具名参数
     *  3. SimpleJdbcTemplate:
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() throws PropertyVetoException {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return namedParameterJdbcTemplate;
    }

}
