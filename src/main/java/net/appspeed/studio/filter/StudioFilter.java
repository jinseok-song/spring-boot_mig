package net.appspeed.studio.filter;

import net.appspeed.studio.interceptor.AppSpeedConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


@Component
public class StudioFilter implements Filter {
    public static Logger logger = LogManager.getLogger(StudioFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
        logger.debug("FILTER INIT");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Remote Host:" + request.getRemoteHost());
        logger.info("Remote Address:" + request.getRemoteAddr());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.debug("destory");
    }

}
