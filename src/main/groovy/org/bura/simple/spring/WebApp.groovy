package org.bura.simple.spring

import javax.servlet.ServletContext
import javax.servlet.ServletException

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

class WebApp implements WebApplicationInitializer {

    @Override
    void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext()
        rootContext.register(WebConfig)
        servletContext.addListener(new ContextLoaderListener(rootContext))

        def registration = servletContext.addServlet('dispatcher', new DispatcherServlet(rootContext))
        registration.loadOnStartup = 1
        registration.addMapping('/springapi/*')
    }
}

@Configuration
@EnableWebMvc
@ComponentScan('org.bura.simple.spring')
class WebConfig extends WebMvcConfigurerAdapter {
}