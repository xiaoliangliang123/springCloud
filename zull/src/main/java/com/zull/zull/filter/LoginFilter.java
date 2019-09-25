package com.zull.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/9/18 10:54
 * @Description :登录校验
 */
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestUrl = request.getRequestURL().toString();
        if(requestUrl.endsWith("/main/login")){
            return false;
        }else if(requestUrl.endsWith("/client/main/mainList")){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        System.out.println(
                "Pre Filter: Request Method : " + request.getMethod() + " " +
                        "Request URL : " + request.getRequestURL().toString()
        +"token :"+token);
        if (StringUtils.isBlank(token)) {
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            //返回错误代码
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
