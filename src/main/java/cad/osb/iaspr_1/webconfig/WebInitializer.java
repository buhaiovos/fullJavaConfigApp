package cad.osb.iaspr_1.webconfig;

import cad.osb.iaspr_1.rootconfig.RepoConfig;
import cad.osb.iaspr_1.rootconfig.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Defining root application context

        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        AnnotationConfigApplicationContext parentContext =
                new AnnotationConfigApplicationContext(RepoConfig.class);
        rootContext.setParent(parentContext);
        rootContext.register(ServiceConfig.class);
        //rootContext.refresh();

        // Register context loader listener

        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Defining dispatcher servlet's config

        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);
        //dispatcherContext.refresh();

        // create and configure dispatcher servlet

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(dispatcherContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        // Register and map dispatcher servlet

        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}
