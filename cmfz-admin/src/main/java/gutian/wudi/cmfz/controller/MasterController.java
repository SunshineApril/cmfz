package gutian.wudi.cmfz.controller;

import gutian.wudi.cmfz.entity.Master;
import gutian.wudi.cmfz.entity.Picture;
import gutian.wudi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 上师contoller
 * @author: gutian
 * @create: 2018-07-06 19:58
 **/
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private  MasterService ms;
    @RequestMapping(value = "/getMas")
    @ResponseBody
    public Map<String, Object> getMaster(@RequestParam("page")Integer page, @RequestParam("rows")Integer single)throws Exception{
        Map<String, Object> stringObjectMap = ms.queryAllMaster(page, single);
        //request.setAttribute("menus",menus);
        //return "forward:/main/main.jsp";\

        return stringObjectMap;

    }

    @RequestMapping("/selectByOther")
    @ResponseBody
    public Map<String, Object> selectEmp(String value, String name, Integer page , Integer rows) {

        System.out.println("jieguo"+value + " " + name +  " " + page +"  "+rows);
        Map<String, Object> stringObjectMap = ms.selectMas(value, name, page, rows);

        return ms.selectMas(value, name, page, rows);
    }

    @RequestMapping("/addMas")
    @ResponseBody
    public String addMas(MultipartFile myFile , HttpSession session, String des, String des1) throws IOException {
        Master master=new Master();
        System.out.println("大师简介"+des1);
        System.out.println("大师名"+des);
        master.setMasterName(des);
        master.setMasterSummary(des1);
        //picture.setPictureDate(new Date());
        //1.获得文件夹名称
        String realPath = session.getServletContext().getRealPath("/");
        String upload = realPath.replace("cmfz-admin", "upload");
        System.out.println("路径"+upload);

//
//        //2.生成UUID的唯一文件名
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        master.setMasterId(uuidName);
//
//        //3.截取文件本身的后缀名
        String oldName = myFile.getOriginalFilename();
        System.out.println("mingcheng"+oldName);
        master.setMasterPhoto(oldName);
        //int i = ms.addPic(picture);
        int i = ms.addMas(master);

        myFile.transferTo(new File(upload+oldName));
//
//        String suffix = oldName.substring( oldName.lastIndexOf(".") );
//
//        myFile.transferTo(new File( realPath +"/"+ uuidName + suffix ));

        return "i";
    }

    @RequestMapping(value = "/updateMas")
    @ResponseBody
    public int updateMas(String masterId,String masterSummary){
        Master master=new Master();
        master.setMasterId(masterId);
        master.setMasterSummary(masterSummary);
//        picture.setPictureId(pictureId);
//        picture.setPictureDescription(pictureDescription);
//        picture.setStatus(status);
//
//        System.out.println(picture);
        int i = ms.modifyMas(master);



        //request.setAttribute("menus",menus);
        //return "forward:/main/main.jsp";\

        return 1;

    }

    /**
    * @Description: 导入excel
    * @Param:
    * @return:
    * @Author: gutian
    * @Date: 2018.07.07
    */


}
