package jaeger.de.miel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;


// https://www.baeldung.com/spring-http-logging

@Configuration
public class RequestLoggingFilterConfig {

// The override is NOT working for the CommonsRequestLoggingFilter class, so we use ServletContextRequestLoggingFilter instead...
//    @Bean
//    public CommonsRequestLoggingFilter logFilter() {
//        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter() {
//
//            @Override
//            protected void afterRequest(HttpServletRequest request, String message) {
//                // No body, we are just overriding the default behavior
//            }
//        };
//
//        filter.setIncludeQueryString(true);
//        filter.setBeforeMessagePrefix("HelloWorldAPI request: ");
//        filter.setBeforeMessageSuffix("");
//        return filter;
//    }


    @Bean
    public ServletContextRequestLoggingFilter requestLoggingFilter() {
        ServletContextRequestLoggingFilter filter = new ServletContextRequestLoggingFilter() {
            @Override
            protected void afterRequest(jakarta.servlet.http.HttpServletRequest request, String message) {
                // No body, we are just overriding the default behavior
            }
        };

        filter.setIncludeQueryString(true);
        filter.setBeforeMessagePrefix("HelloWorldAPI request: ");
        filter.setBeforeMessageSuffix("");

        return filter;
    }

}

