package cn.mb.webapp;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Smile on 2018/4/7.
 */
@Configuration
@MapperScan(basePackages = "cn.mb.dao")
public class MybatisConfig
{
    /**
     * Mybatis Session Factory
     * 依赖：dataSource
     * 扫描：mapper xml 文件
     */
    @Bean
    public SqlSessionFactoryBean sessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:cn/mb/mapper/*Mapper.xml"));
        return sessionFactory;
    }

    /**
     * Mapper Scanner
     * 依赖：sesionFactory
     * 扫描：dao 接口定义
     * 可能在启动时出现：
     *   Cannot enhance @Configuration bean definition 'mapperScannerConfigurer'
     *   since its singleton instance has been created too early.
     * 的错误。问题原因是在 @Configuration 内部注入了 BeanFactoryPostProcessor 实现类 (MapperScannerConfigurer)
     * stackoverflow 建议使用 @MapperScan ：
     *   https://stackoverflow.com/questions/24643426/
     *   java-config-bean-not-autowired-in-other-configuration-class?answertab=votes#tab-top
     */
    /*
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("cn.mb.dao");
        configurer.setSqlSessionFactoryBeanName("sessionFactory");
        return configurer;
    }*/
}
