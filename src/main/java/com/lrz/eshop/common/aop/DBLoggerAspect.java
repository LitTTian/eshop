package com.lrz.eshop.common.aop;

import cn.hutool.core.net.Ipv4Util;
import com.alibaba.fastjson.JSON;
import com.lrz.eshop.mapper.logger.SysOperationMapper;
import com.lrz.eshop.pojo.Logger.SysOperation;
import com.lrz.eshop.util.HttpContextUtils;
import com.lrz.eshop.util.NetworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.IPv6Utils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 天天
 * @create 2023/4/26 10:47
 * @description
 */
@Component
@Aspect // 切面 = 切点 + 通知
@Slf4j
public class DBLoggerAspect {

    @Autowired
    SysOperationMapper sysOperationMapper;

    @Pointcut("@annotation(com.lrz.eshop.common.aop.DBLoggerAnnotation)")
    public void pointcut() {
    }
    // 环绕通知
    @Around("pointcut()")
    public Object dbLogger(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = pjp.proceed(); // 执行方法
        long endTime = System.currentTimeMillis();
        saveDbLogger(pjp, new Date(), endTime - beginTime);
        return result;
    }

    private void saveDbLogger(ProceedingJoinPoint pjp, Date data, long time) {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        DBLoggerAnnotation dbLoggerAnnotation = method.getAnnotation(DBLoggerAnnotation.class);
        // 封装日志信息
        SysOperation sysOperation = new SysOperation();
        sysOperation.setModule(dbLoggerAnnotation.module());
        sysOperation.setOperation(dbLoggerAnnotation.operation());
        Object[] args = pjp.getArgs();
        sysOperation.setParams(JSON.toJSONString(args[0])); // 只获取第一个参数
        sysOperation.setIp(NetworkUtils.getIpAddr(HttpContextUtils.getHttpServletRequest()));
        sysOperation.setCreateTime(data);
        sysOperation.setExecuteTime(time + "ms");
        sysOperationMapper.insert(sysOperation);
        if(Objects.isNull(sysOperation.getId())) {
            log.error("日志保存失败");
        }else {
            log.info("==========================log start==========================");
            log.info("module: {}", sysOperation.getModule());
            log.info("operation: {}", sysOperation.getOperation());
            // 请求的方法名
            String className = pjp.getTarget().getClass().getName();
            String methodName = signature.getName();
            log.info("class: {}, method: {}()", className, methodName);
            log.info("params: {}", sysOperation.getParams());
            //  获取request 设置IP地址
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            log.info("ip: {}", NetworkUtils.getIpAddr(request));
            log.info("execute time: {} ms", time);
            log.info("===========================log end===========================");
        }
    }

}
