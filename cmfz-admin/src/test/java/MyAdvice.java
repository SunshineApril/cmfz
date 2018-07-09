import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @program: cmfz
 * @description:额外功能类
 * @author: gutian
 * @create: 2018-07-09 17:09
 **/
@Aspect
public class MyAdvice {
    /** 
    * @Description: 声明切入点表达式
    * @Param: [] 
    * @return: void 
    * @Author: gutian
    * @Date: 2018.07.09 
    */
    //&& ||  可以一次多个切入点表达式   within（AspectSeerviceImpl）基于类型的aop
    @Pointcut("execution(* *.*(..))")
    public void pc(){}

    /**
     * 前置通知
     */
    @Before("pc()")//表示当前前置通知使用pc方法上的切入点表达式
    public void before(){
        System.out.println("qinazhitongzhi0");
    }
}
