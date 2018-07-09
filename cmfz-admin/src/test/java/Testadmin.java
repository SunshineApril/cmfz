import gutian.wudi.cmfz.dao.ArticleDao;
import gutian.wudi.cmfz.dao.ManagerDao;
import gutian.wudi.cmfz.entity.Article;
import gutian.wudi.cmfz.entity.Manager;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Testadmin {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:aspectJ.xml");
        AspectJService aspectJService = (AspectJService)classPathXmlApplicationContext.getBean("aspectJService");
        String ss = aspectJService.sayHello("sss");
        System.out.println(ss);
        System.out.println("ssss");
    }
}
