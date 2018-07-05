package gutian.wudi.cmfz.controller;

import gutian.wudi.cmfz.entity.Manager;
import gutian.wudi.cmfz.service.ManagerService;
import gutian.wudi.cmfz.utils.NewValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/mgr")
public class ManagerController {
    @Autowired
    private ManagerService ms;
    @RequestMapping("/loginAction_Manager")
    public String loginAction(Manager m, Model mo, String vcode, HttpSession session,HttpServletResponse response,HttpServletRequest request){
        String code = (String)session.getAttribute("vcode");
        System.out.println(code);
        System.out.println("vcode"+vcode);
        if(vcode.equalsIgnoreCase(code)){
            System.out.println("kaishiyanzhengdenglu");
            System.out.println(m);
            boolean _login = ms._login(m);
            if(_login){
                System.out.println("登陆成功");
                mo.addAttribute("managername", m.getMgrName());
                String mgrName = m.getMgrName();
                //String mgrName="曾生";
                String encode=null;
                try {
                   encode = URLEncoder.encode(mgrName, "utf-8");
                    System.out.println(mgrName);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Cookie c1 = new Cookie("cookieName",encode);
                c1.setPath(request.getContextPath());
                response.addCookie(c1);
                return "redirect:/manager/showAllUserAction_Manager";
            }
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
}
