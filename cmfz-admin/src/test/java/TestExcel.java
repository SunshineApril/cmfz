import gutian.wudi.cmfz.entity.Master;

import org.junit.Test;

import java.util.List;

/**
 * @program: cmfz
 * @description: 导入excel测试
 * @author: gutian
 * @create: 2018-07-07 15:22
 **/
public class TestExcel {
    @Test
    //@RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "D:\\master.xlsx";
        //解析excel，
        //List<Master> personList = FileUtils.importExcel(filePath,1,1,Master.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        //System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
    }

}
