package com.ysb.j2we.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class J2weWebAppInitializer implements WebApplicationInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext c = new AnnotationConfigWebApplicationContext();
        c.register(J2weWebAppConfig.class);
        c.setServletContext(servletContext);

        ServletRegistration.Dynamic r = servletContext.addServlet("dispatcher", new DispatcherServlet(c));
        r.setLoadOnStartup(1);
        r.addMapping("/");
    }
}
