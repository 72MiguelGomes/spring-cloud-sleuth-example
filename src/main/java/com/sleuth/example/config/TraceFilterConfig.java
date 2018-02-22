package com.sleuth.example.config;

import com.sleuth.example.filter.CustomTraceFilter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.instrument.web.TraceFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceFilterConfig {

    @Bean
    public TraceFilter traceFilter(BeanFactory beanFactory) {
        return new CustomTraceFilter(beanFactory);
    }

}
