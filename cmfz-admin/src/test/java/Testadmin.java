import gutian.wudi.cmfz.dao.ManagerDao;
import gutian.wudi.cmfz.entity.Manager;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testadmin {
    @Test
    public void testlogin(){
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) c.getBean("managerDao");
        Manager zs = managerDao.findManagerByName("zs");
        System.out.println(zs);

    }
}
