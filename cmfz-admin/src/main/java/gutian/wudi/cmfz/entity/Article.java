package gutian.wudi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: cmfz
 * @description: 文章实体类
 * @author: gutian
 * @create: 2018-07-08 19:44
 **/
public class Article {
    private String articleId;
    private String articleName;
    private String introduction;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date date;
    private String mainPic;
    private String masterId;
    private String articleContext;

    public Article(String articleId, String articleName, String introduction, Date date, String mainPic, String masterId, String articleContext) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.introduction = introduction;
        this.date = date;
        this.mainPic = mainPic;
        this.masterId = masterId;
        this.articleContext = articleContext;
    }

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", date=" + date +
                ", mainPic='" + mainPic + '\'' +
                ", masterId='" + masterId + '\'' +
                ", articleContext='" + articleContext + '\'' +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getArticleContext() {
        return articleContext;
    }

    public void setArticleContext(String articleContext) {
        this.articleContext = articleContext;
    }
}
