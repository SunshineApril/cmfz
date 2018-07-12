package gutian.wudi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import gutian.wudi.cmfz.entity.Manager;
import gutian.wudi.cmfz.entity.Menu;
import gutian.wudi.cmfz.entity.Picture;
import gutian.wudi.cmfz.service.ManagerService;
import gutian.wudi.cmfz.service.MenuService;
import gutian.wudi.cmfz.service.PictureService;
import gutian.wudi.cmfz.utils.NewValidateCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/mgr")
public class ManagerController {
    @Autowired
    private ManagerService ms;
    @Autowired
    private MenuService mes;
    @Autowired
    private PictureService ps;
    @RequestMapping("/loginAction_Manager")
    public String loginAction(Manager m, Model mo, String vcode,boolean remember, HttpSession session,HttpServletResponse response,HttpServletRequest request){
        String code = (String)session.getAttribute("vcode");
        System.out.println(code);
        System.out.println("vcode"+vcode);
        if(vcode.equalsIgnoreCase(code)){
            System.out.println("kaishiyanzhengdenglu");
            System.out.println(m);
            //web环境中springxml中bean自动初始化不用再此配置
            Subject subject = SecurityUtils.getSubject();
            try {
                //shiro会根据boolean值决定是否执行记住我这个功能
                subject.login(new UsernamePasswordToken(m.getMgrName(),m.getMgrPwd(),remember));
                System.out.println(subject.hasRole("admin")?"有root角色":"没有角色");
                System.out.println(subject.isPermitted("master:query")?"拥有上师查询权限":"没有上师查询权限");
                return "main/main";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return "login";
            }
//            boolean _login = ms._login(m);
//            if(_login){
//                System.out.println("登陆成功");
//                session.setAttribute("mgrName",m.getMgrName());
//                mo.addAttribute("managername", m.getMgrName());
//                String mgrName = m.getMgrName();
//                //String mgrName="曾生";
//                String encode=null;
//                if(remember){
//                    try {
//                        encode = URLEncoder.encode(mgrName, "utf-8");
//                        System.out.println(mgrName);
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                    Cookie c1 = new Cookie("cookieName",encode);
//                    c1.setPath(request.getContextPath());
//                    response.addCookie(c1);
//                }
//                return "main/main";
//            }
        }
        return null;
    }

    @RequestMapping(value="/createVcode")
    public String createVcode(HttpServletResponse response, Model model, HttpSession session) throws IOException {
        System.out.println("haha");
        NewValidateCodeUtils newValidateCodeUtils = new NewValidateCodeUtils(150, 70, 4);
        String vcode = newValidateCodeUtils.getCode();
        //model.addAttribute("vcode", vcode);
        //System.out.println(vcode);
        session.setAttribute("vcode", vcode);
       // System.out.println(session.getAttribute("vcode"));

        newValidateCodeUtils.write(response.getOutputStream());
        return null;
    }

    @RequestMapping(value = "/menu")
    @ResponseBody
    public List<Menu> getMenu(HttpServletRequest request){
        List<Menu> menus = mes.querryMenu();


        //request.setAttribute("menus",menus);
        //return "forward:/main/main.jsp";\

        return menus;

    }

    @RequestMapping(value = "/updatePic")
    @ResponseBody
    public int updatePic(String pictureId,String pictureDescription,String status){
        Picture picture = new Picture();
        picture.setPictureId(pictureId);
        picture.setPictureDescription(pictureDescription);
        picture.setStatus(status);

        System.out.println(picture);
        int i = ps.modifyPic(picture);



        //request.setAttribute("menus",menus);
        //return "forward:/main/main.jsp";\

        return 1;

    }

    @RequestMapping(value = "/pic")
    @ResponseBody
    public Map<String, Object> getPicture(@RequestParam("page")Integer page, @RequestParam("rows")Integer single)throws Exception{
        Map<String, Object> stringObjectMap = ps.queryAllPicture(page, single);
        //request.setAttribute("menus",menus);
        //return "forward:/main/main.jsp";\

        return stringObjectMap;

    }

//    @RequestMapping("/addPic")
//    public @ResponseBody void addPicture(MultipartFile newPicture, String pictureMessage, String pictureStatus, MultipartHttpServletRequest request) throws IOException {
//        System.out.println("JINru");
//        String realPath=request.getRealPath("/");
//        int lastIndexOf = realPath.lastIndexOf("\\");
//        String substring = realPath.substring(lastIndexOf);
//        String uploadPath = substring + "\\upload";
//        newPicture.transferTo(new File(uploadPath));
//
//
////        Picture picture=new Picture();
////        picture.setPictureName(newPicture.getOriginalFilename());
////        picture.setPictureMessage(pictureMessage);
////        picture.setPictureStatus(pictureStatus);
////        picture.setPictureDate(new Date());
////
////        pictureService.addPicture(picture);
//    }

    @RequestMapping("/addPic")
    @ResponseBody
    public String addPic(MultipartFile myFile , HttpSession session,String des,String dept) throws IOException {
        Picture picture=new Picture();
        System.out.println("展示状态"+dept);
        System.out.println("描述"+des);
        picture.setPictureDescription(des);
        picture.setStatus(dept);
        picture.setPictureDate(new Date());
        //1.获得文件夹名称
        String realPath = session.getServletContext().getRealPath("/");
        String upload = realPath.replace("cmfz-admin", "upload");
        System.out.println("路径"+upload);

//
//        //2.生成UUID的唯一文件名
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        picture.setPictureId(uuidName);
//
//        //3.截取文件本身的后缀名
        String oldName = myFile.getOriginalFilename();
        System.out.println("mingcheng"+oldName);
        picture.setPicturePath(oldName);
        int i = ps.addPic(picture);
        myFile.transferTo(new File(upload+oldName));
//
//        String suffix = oldName.substring( oldName.lastIndexOf(".") );
//
//        myFile.transferTo(new File( realPath +"/"+ uuidName + suffix ));

        return "i";
    }

}
