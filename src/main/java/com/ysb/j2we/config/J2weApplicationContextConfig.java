package com.ysb.j2we.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ysb.j2we")
public class J2weApplicationContextConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver r = new InternalResourceViewResolver();

        r.setViewClass(JstlView.class);
        r.setPrefix("/WEB-INF/pages/");
        r.setSuffix(".jsp");

        return r;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("/res/");
    }

    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        
        ppc.setLocations(new ClassPathResource("application.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        
        return ppc;
    }
}
