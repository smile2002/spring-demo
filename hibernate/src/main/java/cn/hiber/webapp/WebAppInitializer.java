package cn.hiber.webapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Smile on 2018/4/1.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    /** RootConfig 已经开启 ComponentScan，不需要显示引用其他 Configuration 类 */
    protected Class<?>[] getRootConfigClasses() { return new Class<?>[] { RootConfig.class }; }

    @Override
    protected String[] getServletMappings() { return new String[] { "/" }; }
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
        //servletContext.addListener(new SomeOtherListener(rootContext));

        /** ==== 添加其他 Filters ==== **/
//        FilterRegistration.Dynamic openSessionFilter =
//                servletContext.addFilter("openSessionInViewFilter", new OpenSessionInViewFilter());
//        openSessionFilter.addMappingForUrlPatterns(null, true, "/*");
    }
}