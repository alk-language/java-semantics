package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DemoAspect {

    @Before("execution(* impl.types.AlkValue.add(..))")
    public void logBeforePlus(JoinPoint joinPoint)
    {
        //System.out.println("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* impl.types.AlkValue.subtract(..))")
    public void logBeforeMinus(JoinPoint joinPoint)
    {
        //System.out.println("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
    }
}
