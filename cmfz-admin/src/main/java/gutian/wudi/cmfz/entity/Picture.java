package gutian.wudi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: cmfz
 * @description: 轮播图片实体类
 * @author: gutian
 * @create: 2018-07-05 19:58
 **/
public class Picture {
    private String pictureId;
    private String picturePath;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date pictureDate;
    private String pictureDescription;
    private String status;

    public Picture(String pictureId, String picturePath, Date pictureDate, String pictureDescription, String status) {
        this.pictureId = pictureId;
        this.picturePath = picturePath;
        this.pictureDate = pictureDate;
        this.pictureDescription = pictureDescription;
        this.status = status;
    }

    public Picture() {
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", pictureDate=" + pictureDate +
                ", pictureDescription='" + pictureDescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Date getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(Date pictureDate) {
        this.pictureDate = pictureDate;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
