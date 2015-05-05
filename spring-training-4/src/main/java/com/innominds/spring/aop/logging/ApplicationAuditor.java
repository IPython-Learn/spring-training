package com.innominds.spring.aop.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * The Class ApplicationAuditor acts as logging aspect to monitor method execution time.
 */
@Component
@Aspect
public class ApplicationAuditor {

    /** The logger. */
    private static Logger LOGGER = Logger.getLogger("LOGGING ASPECT");

    /** The Constant constantNum. */
    private static final int CONSTANTNUMBER = 1000000;

    /** The Constant hashString. */
    private static final String HASHSTRING = "###";

    /**
     * Service method execution time.
     *
     * @param jointPoint
     *            the joint point
     * @return the object
     * @throws Throwable
     *             the throwable
     */
    @Around("execution(* com.innominds.spring.dao.impl.*.*(..))")
    public static Object serviceMethodExecutionTime(final ProceedingJoinPoint jointPoint) throws Throwable {

        final long startTime = System.nanoTime();

        final Object returnType = jointPoint.proceed();

        final long delta = (System.nanoTime() - startTime) / ApplicationAuditor.CONSTANTNUMBER;

        System.out.println();
        System.out.println(ApplicationAuditor.HASHSTRING + jointPoint.getSignature().getDeclaringType().getSimpleName() + "."
                + jointPoint.getSignature().getName() + " Executed in [" + delta + "] ms. " + ApplicationAuditor.HASHSTRING);
        System.out.println();

        ApplicationAuditor.LOGGER.warn(ApplicationAuditor.HASHSTRING + jointPoint.getSignature().getDeclaringType().getSimpleName() + "."
                + jointPoint.getSignature().getName() + " Executed in [" + delta + "] ms. " + ApplicationAuditor.HASHSTRING);

        return returnType;
    }

}
