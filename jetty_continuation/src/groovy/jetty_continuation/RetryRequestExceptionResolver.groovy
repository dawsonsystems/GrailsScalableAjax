package jetty_continuation;

import org.codehaus.groovy.grails.web.errors.GrailsExceptionResolver;
import org.codehaus.groovy.grails.web.servlet.mvc.exceptions.ControllerExecutionException;
import org.codehaus.groovy.runtime.InvokerInvocationException;
import org.mortbay.jetty.RetryRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetryRequestExceptionResolver extends GrailsExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

        if (e instanceof InvokerInvocationException
                || e instanceof ControllerExecutionException) {
            if (getRootCause(e) instanceof RetryRequest) {
                throw getRootCause(e);
            }
        }
        return super.resolveException(request, response, handler, e)
    }
}
