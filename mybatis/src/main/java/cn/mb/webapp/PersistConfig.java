package cn.mb.webapp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 * Created by Smile on 2018/4/3.
 */
@Configuration
@EnableTransactionManagement
public class PersistConfig {
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

    @Bean
    public SqlSessionFactoryBean sessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("cn.mb.dao");
        configurer.setSqlSessionFactoryBeanName("sessionFactory");
        return configurer;
    }


    /**
     * transactionManager
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }
}
