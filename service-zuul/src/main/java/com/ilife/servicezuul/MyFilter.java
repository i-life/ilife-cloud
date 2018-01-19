package com.ilife.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

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
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s >>> %s",
                request.getMethod(),
                request.getRequestURL().toString()));

        String accessToken = request.getParameter("token");
        if (StringUtils.isEmpty(accessToken)) {
            logger.warn("Token is empty.");

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try {
                ctx.getResponse().getWriter().write("Token is empty.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("OK");
        }

        return null;
    }
}
