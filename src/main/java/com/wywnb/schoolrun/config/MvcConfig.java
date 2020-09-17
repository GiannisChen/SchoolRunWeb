package com.wywnb.schoolrun.config;

import com.wywnb.schoolrun.component.LoginHandlerInterceptor;
import com.wywnb.schoolrun.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private static final List<String> EXCLUDE_PATH = Arrays.asList(
            "/", "/index", "/index.html", "/dashboard/**", "/asserts/**", "/webjars/**", "/login", "/asserts/js/**", "/logup/**"
    );



    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH);
    }
}
