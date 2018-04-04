package cn.xiao.webapp;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Enumeration;

/**
 * 偏底层，需要手动设置 DispatcherServlet、ContextLoadListener 等
 */
public class MyServletInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {


        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        int i = 0;
        System.out.println("Attributes: ");
        while (attributeNames.hasMoreElements()) {
            String nextElement = attributeNames.nextElement();
            System.out.print(++i + ":" + nextElement + ":");
            Object attribute = servletContext.getAttribute(nextElement);
            System.out.println(attribute);
        }
        Enumeration<String> paramNames = servletContext.getInitParameterNames();
        i=0;
        System.out.println("InitParameters: ");
        while (paramNames.hasMoreElements()) {
            String nextElement = paramNames.nextElement();
            System.out.print(++i + ":" + nextElement + ":");
            Object param = servletContext.getInitParameter(nextElement);
            System.out.println(param);
        }

        System.out.println("Vurtial Server Nmae = " + servletContext.getVirtualServerName());
        System.out.println("Server Info = " + servletContext.getServerInfo());
        System.out.println("Servlet Context Name = " + servletContext.getServletContextName());


        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(ServletConfig.class);

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
