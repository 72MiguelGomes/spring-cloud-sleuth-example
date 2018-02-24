package com.sleuth.example.config;

import com.sleuth.example.filter.CustomTraceFilter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.instrument.web.TraceFilter;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringCloudSleuthConfig {

    @Bean
    public TraceFilter traceFilter(BeanFactory beanFactory) {
        return new CustomTraceFilter(beanFactory);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }

}
