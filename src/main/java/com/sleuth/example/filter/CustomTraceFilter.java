package com.sleuth.example.filter;

import brave.Tracer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.instrument.web.TraceFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomTraceFilter extends TraceFilter {

    private static final String TRACE_HEADER_NAME = "X-B3-TraceId";
    private final BeanFactory beanFactory;
    private Tracer tracer;

    public CustomTraceFilter(BeanFactory beanFactory) {
        super(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, new CustomFilterChain(filterChain));
    }

    private Tracer tracer() {
        if (this.tracer == null) {
            this.tracer = this.beanFactory.getBean(Tracer.class);
        }
        return this.tracer;
    }

    private class CustomFilterChain implements FilterChain {

        private final FilterChain filterChain;

        private CustomFilterChain(FilterChain filterChain) {
            this.filterChain = filterChain;
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse)servletResponse;

            response.addHeader(TRACE_HEADER_NAME, tracer().currentSpan().context().traceIdString());

            this.filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

