package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理的pre类型的过滤器
 *
 * @author dlz
 * @date 2020/8/28
 * @description
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    public boolean shouldFilter() {
        return true;
    }

    /**
     * 对run()方法进行改造才可以捕获异常
     * error.status_code：错误编码
     * error.exceptuion:Exception异常对象
     * error.message：错误信息
     *
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        log.info("This is a pre filter,it will throw a RuntimeException");
        RequestContext requestContext = RequestContext.getCurrentContext();
        try {
            doSomething();
        } catch (Exception e) {
            requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            requestContext.set("error.exception", e);
            requestContext.set("error.message",e.getMessage());
        }
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors......");
    }
}
