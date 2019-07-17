package aop.execution;

import analysis.Analysis;
import impl.visitors.StmtVisitor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExecutionAspect {

    /*@Before("@annotation(Loop)")
    public void increaseLoop()
    {

    }*/

    @Around("execution(* impl.visitors.StmtVisitor.*(..) )")
    public Object stopAssignmentStmt(ProceedingJoinPoint joinPoint) throws Throwable {
        StmtVisitor visitor = (StmtVisitor) joinPoint.getThis();
        if (visitor.breakFlag || visitor.continueFlag || visitor.returnValue != null)
            return null;
        return joinPoint.proceed();
    }
}
