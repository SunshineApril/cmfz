package gutian.wudi.cmfz.controller;

import gutian.wudi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-09 20:58
 **/
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService ls;
    @RequestMapping(value = "/getlog")
    @ResponseBody
    public Map<String, Object> getLog(@RequestParam("page")Integer page, @RequestParam("rows")Integer single)throws Exception{
        Map<String, Object> stringObjectMap = ls.queryAllLog(page, single);
        //request.setAttribute("menus",menus);
        //return "forward:/main/main.jsp";\

        return stringObjectMap;

    }
}
