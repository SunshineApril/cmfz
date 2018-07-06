import gutian.wudi.cmfz.dao.MasterDao;
import gutian.wudi.cmfz.entity.Master;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: cmfz
 * @description: master测试类
 * @author: gutian
 * @create: 2018-07-06 21:10
 **/
public class TestMaster {
    @Test
    public void testmenu() {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
        MasterDao managerDao = (MasterDao) c.getBean("masterDao");

//        List<Master> masters = managerDao.selectMas("2", "master_Name", 1, 5);
//
//        for (Master master : masters) {
//            System.out.println(master);
//        }
        Master master = new Master("2", "3", "3", "33");
        int i = managerDao.updateMas(master);

        System.out.println(i);


    }
}
