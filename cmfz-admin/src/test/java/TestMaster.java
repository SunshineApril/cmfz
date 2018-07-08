import gutian.wudi.cmfz.dao.MasterDao;
import gutian.wudi.cmfz.entity.Master;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
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
//        Master master = new Master("2", "3", "3", "33");
//        int i = managerDao.updateMas(master);
//
//        System.out.println(i);

        List<Master> msl=new ArrayList<Master>();
        Master master1 = new Master("23", "3", "3", "33");
        Master master2 = new Master("24", "3", "3", "33");
        Master master3 = new Master("25", "3", "3", "33");
        msl.add(master1);
        msl.add(master2);
        msl.add(master3);
        managerDao.inseertMaster(msl);
    }
}
