package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器：请求过滤
 * 过滤器必须包含4个基本特征：过滤类型、执行顺序、执行条件、具体操作。
 * 这些元素实际上就是ZuulFilter接口中定义的4个抽象方法。
 *
 * @author dlz
 * @date 2020/8/27
 * @description
 */
@Component
public class AccessFilter extends ZuulFilter {
    
    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);
    
    /**
     * 过滤器的类型，它决定过滤器在请求的那个生命周期中执行，具体如下所示：
     * pre：可以在请求被路由之前调用。
     * routing：在路由请求时被调用
     * post：在routing和error过滤器之后被调用。
     * error：处理请求事发生错误时被调用。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器是，
     * 需要根据该方法返回的值来依次执行，数值越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里返回true，
     * 因此该过滤器对所有的请求都会生效
     *
     * @return
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (null == accessToken) {
            log.warn("accessToken is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access Token ok");
        return null;
    }
}
