package net.appspeed.studio.aop;

import net.appspeed.studio.controller.HelloController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudioAop {
    public static final Logger logger = LogManager.getLogger(HelloController.class);

    @Around("execution(* net.appspeed.studio.service.*.*(..))")
    public Object controlerAop(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String errorMessage = "";

        logger.debug("============aop=====================");
        result = joinPoint.proceed();
        return result;
    }

}
