package gutian.wudi.cmfz.controller;

import gutian.wudi.cmfz.entity.Article;
import gutian.wudi.cmfz.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-09 15:47
 **/
@Controller
@RequestMapping(value = "/area")
public class AreaController {
    @RequestMapping(value = "/nan")
    @ResponseBody
    public List<People> getp2(){
        List ss=new ArrayList<People>();
        People s = new People("河南", 4);
        People s1 = new People("北京", 4);


        People s2 = new People("天津", 4);

        ss.add(s);
        ss.add(s1);
        ss.add(s2);
        return  ss;
    }
    @RequestMapping(value = "/nv")
    @ResponseBody
    public List<People> getp(){
        List ss=new ArrayList<People>();
        People s = new People("河南", 4);
        People s1 = new People("北京", 4);
        People s3 = new People("南京", 5);

        People s2 = new People("天津", 4);

        ss.add(s);
        ss.add(s1);
        ss.add(s2);
        ss.add(s3);
        return  ss;
    }
}
