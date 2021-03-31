package com.nitesh.springLearning.config;
import com.nitesh.springLearning.filter.NewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<NewFilter> registrationBean(){
        FilterRegistrationBean<NewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new NewFilter());
        registrationBean.addUrlPatterns("/customer/*");
        return registrationBean;
    }


}
