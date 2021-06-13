package net.appspeed.studio.filter;

import lombok.extern.log4j.Log4j2;
import net.appspeed.studio.interceptor.AppSpeedConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Log4j2
@Component
public class StudioFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("FILTER INIT");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("=====================filter 시작부분============================");
        log.info("Remote Host:" + request.getRemoteHost());
        log.info("Remote Address:" + request.getRemoteAddr());
        log.info("=====================filter 종료부분============================");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("===========================filter Destroy===========================");
    }

}
