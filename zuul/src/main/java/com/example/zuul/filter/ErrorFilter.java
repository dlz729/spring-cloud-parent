package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author dlz
 * @date 2020/8/28
 * @description
 */
@Component
public class ErrorFilter extends ZuulFilter {
    
    public static Logger log= LoggerFactory.getLogger(ErrorFilter.class);
    
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext requestContext=RequestContext.getCurrentContext();
        Throwable throwable=requestContext.getThrowable();
        log.error("this is a ErrorFilter:{}",throwable.getCause().getMessage());
        requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        requestContext.set("error.exception",throwable.getCause());
        return null;
    }
}
