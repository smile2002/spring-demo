package cn.hiber.webapp;

import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Smile on 2018/4/1.
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings OK");
        return new String[] { "/" };
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                RootConfig.class,
                PersistConfig.class
        };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServletConfig.class };
    }

    @Override
    protected Filter[] getServletFilters() {
        return null;
    }

    public void onStartup(ServletContext servletContext) throws ServletException {
        /** 设置 DipatchServlet 及 ContextLoaderListener **/
        super.onStartup(servletContext);

        /** ==== 添加其他 Listener ==== **/
        /*
        servletContext.addListener(new SomeOtherListener(rootContext));
        */

        /** ==== 添加其他 Filters ==== **/
//        FilterRegistration.Dynamic openSessionFilter = servletContext.addFilter("openSessionInViewFilter", new OpenSessionInViewFilter());
//        openSessionFilter.addMappingForUrlPatterns(null, true, "/*");
    }
}