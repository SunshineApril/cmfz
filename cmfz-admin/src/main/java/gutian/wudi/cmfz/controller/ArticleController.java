package gutian.wudi.cmfz.controller;

import gutian.wudi.cmfz.entity.Article;
import gutian.wudi.cmfz.entity.RichTextResult;
import gutian.wudi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-08 21:08
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService as;
    @RequestMapping(value = "/insertar")
    public void createArticle(String p1,String des,String dept){
        Article article = new Article();

        //更改get的编码
//        String username = null;
//        try {
//            username = new String(request.getParameter("context").getBytes("iso8859-1"),"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println(p1);
        System.out.println(des);
        System.out.println(dept);
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        article.setArticleId(uuidName);
        article.setArticleName(des);
        article.setDate(new Date());
        article.setMasterId(dept);
        article.setArticleContext(p1);
        System.out.println(article);
        int i = as.addArticle(article);
        System.out.println(i);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<String>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }
}
