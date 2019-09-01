package net.devstudy.resume.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan({"net.devstudy.resume.service.impl",
                "net.devstudy.resume.controller",
                "net.devstudy.resume.filter",
                "net.devstudy.resume.listener"})

public class ServiceConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException{
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(getResources());
        return conf;
    }

    private static Resource[] getResources() {
        return new Resource[] {
                new ClassPathResource("application.properties"),
                new ClassPathResource("logic.properties")
        };
    }
}
