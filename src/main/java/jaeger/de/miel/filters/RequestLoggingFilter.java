package jaeger.de.miel.filters;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;


// https://www.baeldung.com/spring-http-logging

@Component
public class RequestLoggingFilter extends ServletContextRequestLoggingFilter  {

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        // No body, we are just overriding the default behavior
    }

    public RequestLoggingFilter() {
        this.setIncludeQueryString(true);
        this.setIncludeHeaders(false);
        this.setBeforeMessagePrefix("HelloWorldAPI request: ");
        this.setBeforeMessageSuffix("");
    }

}

