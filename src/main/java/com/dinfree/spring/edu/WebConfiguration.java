package com.dinfree.spring.edu;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    //TODO: 페이지 설정 부분인데 보강 필요.
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setPageParameterName("page.page");
        resolver.setSizeParameterName("page.size");
        resolver.setOneIndexedParameters(true);
        resolver.setFallbackPageable(PageRequest.of(0, 4));
        argumentResolvers.add(resolver);
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
                /*
        registry.addViewController("/addrbook/addrbook_list").setViewName("/addrbook/list");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        */
    }
}
