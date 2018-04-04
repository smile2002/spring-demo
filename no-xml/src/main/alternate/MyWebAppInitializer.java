package cn.xiao.webapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Spring 对 WebApplicationInitializer 的进一步封装
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings OK");
        return new String[] { "/" };
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };

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

        /** ==== 添加其他 Servlet ==== **/
        /*
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        webContext.register(appConfig.class);
        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("servletName", new AppServlet(appContext));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/app");
        */

        /** ==== 添加其他 Filters ==== **/
        /*
        FilterRegistration.Dynamic xxxFilter = servletContext.addFilter(...
        */
    }
}

/**
 * 另一种偏底层的方式：直接实现 WebApplicationInitializer 接口 onStartup 方法，
 * 手动设置 DispatchServlet、ContextLoadListener 等
 */
/*
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherConfig.class);

        // Will not be used
        //XmlWebApplicationContext dispacherContext = new XmlWebApplicationContext();
        //dispacherContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        FilterRegistration.Dynamic xxxFilter = servletContext.addFilter("xxxFilter", new XxxFilter());
    }
}
*/
