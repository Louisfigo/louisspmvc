package org.louis.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("org.louis.springmvc")
@EnableScheduling
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

    @Bean public MultipartResolver multipartResolver()
    {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000000);
        return  multipartResolver;
    }

    @Bean
    public DemoInterceptor demoInterceptor()
    {
        return  new DemoInterceptor();
    }

    @Bean
    public MyMessageConvert myMessageConvert()
    {
        return new  MyMessageConvert();
    }

    @Override
    public  void extendMessageConverters(List<HttpMessageConverter<?>> converterList)
    {
        converterList.add(myMessageConvert());
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

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
    }
}
