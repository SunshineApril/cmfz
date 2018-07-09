package gutian.wudi.cmfz.utils;

import gutian.wudi.cmfz.dao.LogDao;
import gutian.wudi.cmfz.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:额外功能类
 * @author: gutian
 * @create: 2018-07-09 17:09
 **/
@Aspect
public class MyAdvice {
    @Autowired
    private LogDao logDao;
     /**
    * @Description: 声明切入点表达式
    * @Param: [] 
    * @return: void 
    * @Author: gutian
    * @Date: 2018.07.09 
    */
    //&& ||  可以一次多个切入点表达式   within（AspectSeerviceImpl）基于类型的aop
    @Pointcut("execution(* gutian.wudi.cmfz.service.*Impl.modify*(..)) ||execution(* gutian.wudi.cmfz.service.*Impl.add*(..))")
    public void pc(){}

    /**
     * 前置通知
     */
   // @Before("pc()")//表示当前前置通知使用pc方法上的切入点表达式

//    public void before(){
//        System.out.println("qinazhitongzhi0");
//    }
    /**
     * 环绕通知
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        Log log = new Log();

        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session =request.getSession();
        String mgrName = (String)session.getAttribute("mgrName");
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        log.setLogId(uuidName);
        log.setLogUser(mgrName);
        log.setLogTime(new Date());


        //参数数组
        Object[] args = pjp.getArgs();

        String s2 = args[0].getClass().toString();
        log.setLogResource(s2);
        //获取签名之后可以获取方法的签名
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        //获取方法
        Method method = signature.getMethod();
        //获取方法名称
        String name = method.getName();
        if(name.contains("add")){
            log.setLogAction("新增");
        }else{
            log.setLogAction("修改");
        }
        String s="";
        for (Object o : args) {
            String s1 = o.toString();
            s = s.concat(s1);
        }
        log.setLogMessage(s);
        System.out.println("huanraozhiqian");
        Object proceed = null;
        try {
            proceed = pjp.proceed();
            log.setLogResult("success");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.setLogResult("fail");
        }
        logDao.insertLog(log);
        return proceed;


    }
}
