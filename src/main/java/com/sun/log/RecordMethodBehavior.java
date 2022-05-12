package com.sun.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * TODO
 *
 * @author sunyl
 * @date 2022/5/7 16:52
 * @see com.sun.log
 */
@Aspect
@Component
public class RecordMethodBehavior {

    private static final Logger LOGGER = LogManager.getLogger(RecordMethodBehavior.class);

    @Around("execution(* com.sun..*(..)))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        final StopWatch stopWatch = new StopWatch();

        // calculate method execution time
        stopWatch.start();
        Object res = joinPoint.proceed();
        stopWatch.stop();

        // log method execution time
        LOGGER.info("Execution time of "
                + methodSignature.getDeclaringType().getSimpleName() // class name
                + "." + methodSignature.getName() // method name
                + ": " + stopWatch.getTotalTimeMillis() + "ms");
        return res;
    }
}
