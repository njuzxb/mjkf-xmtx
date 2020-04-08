package com.xmtx.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //System.out.println(request.getRequestURI()); ///apigateway/product/api/v1/product/list
        //System.out.println(request.getRequestURL()); //http://localhost:9000/apigateway/product/api/v1/product/list

        //忽略大小写，返回true则拦截，进入run方法
        if ("/apigateway/order/api/v1/order/save".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }else if ("/apigateway/order/api/v1/order/list".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }else if ("/apigateway/order/api/v1/order/find".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }

        return false;
    }

    public Object run() throws ZuulException {
        return null;
    }
}
