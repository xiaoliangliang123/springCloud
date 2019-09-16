package com.base.base.config.db;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatasourceAop extends BaseDao {

    private final static Logger logger = LoggerFactory.getLogger(DatasourceAop.class);


    @Around("execution(* com..*.JBaseDao.insert*(..))||execution(* com..*.JBaseDao.update*(..))||execution(* com..*.JBaseDao.delete*(..))")
    public Object doWriteAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (!DatasourceContextHolder.isSeturrentDb()) {
            DatasourceContextHolder.write();
        }

        return proceedingJoinPoint.proceed();
    }


    @Around("execution(* com..*.JBaseDao.query*(..))||execution(* com..*.JBaseDao.select*(..))")
    public Object doReadAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (!DatasourceContextHolder.isSeturrentDb()) {
            DatasourceContextHolder.read();
        }
        return proceedingJoinPoint.proceed();
    }

}
