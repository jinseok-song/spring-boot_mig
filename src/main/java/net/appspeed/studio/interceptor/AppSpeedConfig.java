package net.appspeed.studio.interceptor;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Log4j2
@Configuration
public class AppSpeedConfig implements WebMvcConfigurer {
    public static Logger logger = LogManager.getLogger(AppSpeedConfig.class);


    @Override
    public void addInterceptors(InterceptorRegistry registry) {




        logger.debug("======================net.appspeed.studio.interceptor====================");
        logger.debug("======================net.appspeed.studio.interceptor====================");
        logger.debug("======================net.appspeed.studio.interceptor====================");
        logger.debug("======================net.appspeed.studio.interceptor====================");
        logger.debug("======================net.appspeed.studio.interceptor====================");
        logger.debug("======================net.appspeed.studio.interceptor====================");

        registry.addInterceptor(new StudioInterceptor()).addPathPatterns("/**");

        logger.debug("======================interceptor2====================");
        logger.debug("======================interceptor2====================");
        logger.debug("======================interceptor2====================");
        logger.debug("======================interceptor2====================");


    }
}