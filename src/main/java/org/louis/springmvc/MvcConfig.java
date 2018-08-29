package org.louis.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("org.louis.springmvc")
public class MvcConfig  extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(ViewResolver viewResolver)
    {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/classes/views/");

        internalResourceViewResolver.setSuffix(".jsp");

        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;

    }

    @Bean
    public DemoInterceptor demoInterceptor()
    {
        return  new DemoInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry)
    {
        resourceHandlerRegistry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
}
