import gutian.wudi.cmfz.dao.ArticleDao;
import gutian.wudi.cmfz.dao.ManagerDao;
import gutian.wudi.cmfz.entity.Article;
import gutian.wudi.cmfz.entity.Manager;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Testadmin {
    @Test
    public void testlogin(){
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ManagerDao managerDao = (ManagerDao) c.getBean("managerDao");
//        Manager zs = managerDao.findManagerByName("zs");
//        System.out.println(zs);
        ArticleDao managerDao = (ArticleDao) c.getBean("articleDao");
        Article article = new Article("1","2","3",new Date(),"5","6","5");


        managerDao.insertArt(article);


    }
}
