import gutian.wudi.cmfz.dao.MenuDao;
import gutian.wudi.cmfz.entity.Menu;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: cmfz
 * @description: 测试查询目录
 * @author: gutian
 * @create: 2018-07-05 11:54
 **/
public class Testmenu {
    @Test
    public void testmenu() {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuDao managerDao = (MenuDao) c.getBean("menuDao");

        List<Menu> allMenu = managerDao.findAllMenu();
        for (Menu menu : allMenu) {
            System.out.println(menu);
        }


    }
}
