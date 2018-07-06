import gutian.wudi.cmfz.dao.PictureDao;
import gutian.wudi.cmfz.entity.Picture;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @program: cmfz
 * @description: 轮播图的测试类
 * @author: gutian
 * @create: 2018-07-05 20:17
 **/
public class TestPicture {
    @Test
    public void testmenu() {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
        PictureDao managerDao = (PictureDao) c.getBean("pictureDao");

//        List<Picture> allPicture = managerDao.findAllPicture();
//        System.out.println(allPicture);


//        List<Picture> allPicture = managerDao.findAllPicture(1, 5);
//        for (Picture picture : allPicture) {
//            System.out.println(picture);
//        }
        Picture picture=new Picture("7","1.jpg",new Date(),"ssss","展示中");

        managerDao.insertPic(picture);


        int totalPic = managerDao.getTotalPic();
                System.out.println(totalPic);
    }
}
