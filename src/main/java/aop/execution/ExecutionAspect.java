package aop.execution;

import parser.visitors.StmtVisitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExecutionAspect {

    /*@Before("@annotation(Loop)")
    public void increaseLoop()
    {

    }*/

    @Around("execution(* parser.visitors.StmtVisitor.*(..) )")
    public Object stopAssignmentStmt(ProceedingJoinPoint joinPoint) throws Throwable {
        StmtVisitor visitor = (StmtVisitor) joinPoint.getThis();
        if (visitor.breakFlag || visitor.continueFlag || visitor.returnValue != null)
            return null;
        return joinPoint.proceed();
    }
}
