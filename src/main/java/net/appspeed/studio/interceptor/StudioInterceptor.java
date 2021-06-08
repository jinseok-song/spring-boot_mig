package net.appspeed.studio.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudioInterceptor implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(StudioInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.print("1231313131313211312132131321"+request);
        logger.debug("============================33333INTERCEPTOR33333==============================");

        return true;
    }

}
