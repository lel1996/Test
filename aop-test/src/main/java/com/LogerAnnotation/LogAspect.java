package com.LogerAnnotation;

import java.lang.reflect.Method;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component("logAspect")
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    // ����֯���
    @Pointcut("@annotation(com.LogerAnnotation.Loger)")
    public void logPointCut() {
    }

    /**
     * ǰ��֪ͨ �������ز������ڷ������غ�ִ��
     * @param joinPoint �е�
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    /**
     * �����쳣���������쳣ʱִ��
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    private void handleLog(JoinPoint joinPoint, Exception e) {
        try {
            // ���ע��
            Log controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null) {
                return;
            }
            // ��÷�������
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
           /* String action = controllerLog.action();
            String title = controllerLog.title();
            //��ӡ��־��������Ҫ�����Դ������ݿ�
            log.info(">>>>>>>>>>>>>ģ�����ƣ�{}",title);
            log.info(">>>>>>>>>>>>>�������ƣ�{}",action);*/
            log.info(">>>>>>>>>>>>>������{}",className);
            log.info(">>>>>>>>>>>>>��������{}",methodName);
        } catch (Exception exp) {
            // ��¼�����쳣��־
            log.error("==ǰ��֪ͨ�쳣==");
            log.error("�쳣��Ϣ:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * �Ƿ����ע�⣬������ھͻ�ȡ
     */
    private static Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }
}