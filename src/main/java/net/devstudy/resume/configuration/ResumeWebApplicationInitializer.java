package net.devstudy.resume.configuration;


import net.devstudy.resume.filter.ApplicationFilter;
import net.devstudy.resume.filter.ResumeFilter;
import net.devstudy.resume.listener.ApplicationListener;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class ResumeWebApplicationInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext container) throws ServletException {
        WebApplicationContext ctx = createWebApplicationContext(container);

        container.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
        container.addListener(new ContextLoaderListener(ctx));
        container.addListener(ctx.getBean(ApplicationListener.class));

        registerFilters(container,ctx);
        //registerServlet(container,ctx.getBean(ProfileController.class),"/profile");
        registerSpringMVCDispatcherServlet(container,ctx);
    }



    private WebApplicationContext createWebApplicationContext(ServletContext container) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.scan("net.devstudy.resume.configuration");
        ctx.setServletContext(container);
        ctx.refresh();
        return ctx;





    }

    public void func(String query, String... params){

    }


    private void registerFilters(ServletContext container, WebApplicationContext ctx) {
        registerFilter(container,ctx.getBean(ApplicationFilter.class));
        registerFilter(container,ctx.getBean(ResumeFilter.class));
        registerFilter(container,new CharacterEncodingFilter("UTF-8",true));
        registerFilter(container,new OpenEntityManagerInViewFilter());
        registerFilter(container,buildConfigurableSiteMeshFilter(),"siteMesh");
    }



    private void registerFilter(ServletContext container, Filter filter, String... filterNames) {
        String filterName = filterNames.length > 0 ? filterNames[0] : filter.getClass().getSimpleName();
        container.addFilter(filterName,filter).addMappingForUrlPatterns(null,true,"/*");

    }

//    private void registerServlet(ServletContext container, Servlet servletInstance, String url) {
//        ServletRegistration.Dynamic servlet = container.addServlet(servletInstance.getClass().getSimpleName(),servletInstance);
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping(url);
//
//    }







    private void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx){
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

    private ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() {
        return new ConfigurableSiteMeshFilter(){
            @Override
            protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
                builder.addDecoratorPath("/*","/WEB-INF/templates/page-template.jsp");
            }
        };


    }


}
