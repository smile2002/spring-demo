package cn.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Smile on 2018/4/4.
 */
@Aspect
public class MyUtil {

    @Pointcut("execution(** cn.aop.service.SampleService.service(..))")
    public void service() {}

    @Before("service()")
    public void getReady1(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String param = (String)args[0];
        System.out.println("1. Silencing cell phones " + param);
    }

    @Before("service()")
    public void getReady2(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String param = (String)args[0];
        System.out.println("2. Take seats " + param);
    }
    @AfterReturning("service()")
    public void applause(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String param = (String)args[0];
        System.out.println("3. CLAP CLAP CLAP!!! " + param);
    }
    @AfterThrowing("service()")
    public void demandRefund(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String param = (String)args[0];
        System.out.println("E. Demanding a refund " + param);
    }
}
