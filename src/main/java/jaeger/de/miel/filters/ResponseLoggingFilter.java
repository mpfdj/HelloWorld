package jaeger.de.miel.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

// https://stackoverflow.com/questions/42414422/convert-httpservletresponse-to-string

public class ResponseLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, responseWrapper);

        byte[] responseArray = responseWrapper.getContentAsByteArray();
        String responseStr = new String(responseArray, responseWrapper.getCharacterEncoding());
        int statusCode = ((HttpServletResponse) servletResponse).getStatus();
        servletRequest.getServletContext().log("HelloWorldAPI response: " + statusCode + " " + responseStr);

        responseWrapper.copyBodyToResponse();
    }

}


