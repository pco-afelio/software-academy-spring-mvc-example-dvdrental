package be.afelio.software_academy.spring_mvc.example.dvdrental.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class BootConfig implements WebApplicationInitializer {
	
    @Override
    public void onStartup(final ServletContext sc) throws ServletException {
 
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
         
        root.scan("be.afelio.software_academy.spring_mvc.example.dvdrental.config");
        sc.addListener(new ContextLoaderListener(root));
 
        ServletRegistration.Dynamic appServlet = 
        		sc.addServlet("dispatch", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
