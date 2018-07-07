package gutian.wudi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @program: cmfz
 * @description: 上师实体类
 * @author: gutian
 * @create: 2018-07-06 17:26
 **/
public class Master {
    @Excel(name = "上师编号" ,orderNum = "0")
    private String masterId;
    @Excel(name = "上师名称" ,orderNum = "1")
    private String masterName;
    @Excel(name = "上师照片",orderNum = "2")
    private String masterPhoto;
    @Excel(name = "上师介绍" ,orderNum = "3")
    private String masterSummary;

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummary() {
        return masterSummary;
    }

    public void setMasterSummary(String masterSummary) {
        this.masterSummary = masterSummary;
    }

    public Master() {
    }

    public Master(String masterId, String masterName, String masterPhoto, String masterSummary) {
        this.masterId = masterId;
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterSummary = masterSummary;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummary='" + masterSummary + '\'' +
                '}';
    }
}
