package jaeger.de.miel.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.UrlPathHelper;

import java.io.IOException;

// https://stackoverflow.com/questions/42414422/convert-httpservletresponse-to-string

public class ResponseLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // We can move logic from RequestLoggingFilter to this Filter and have logging in 1 place.


        String responseStr = "";

        String path = new UrlPathHelper().getPathWithinApplication((HttpServletRequest) servletRequest);
        String[] pathParams = path.split("/");

        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, responseWrapper);

        byte[] responseArray = responseWrapper.getContentAsByteArray();

        if (pathParams.length > 2) {
            responseStr = new String(responseArray, responseWrapper.getCharacterEncoding());
        }

        int statusCode = ((HttpServletResponse) servletResponse).getStatus();
        servletRequest.getServletContext().log("HelloWorldAPI response: " + statusCode + " " + responseStr);

        responseWrapper.copyBodyToResponse();
    }

}


