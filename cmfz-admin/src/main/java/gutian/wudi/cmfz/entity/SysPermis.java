package gutian.wudi.cmfz.entity;

/**
 * @program: cmfz
 * @description: 权限实体类
 * @author: gutian
 * @create: 2018-07-12 14:37
 **/
public class SysPermis {
    private String resourceId;
    private String resourceTag;
    private String resourceUrl;
    private String permisTag;
    private String resourceName;

    public SysPermis(String resourceId, String resourceTag, String resourceUrl, String permisTag, String resourceName) {
        this.resourceId = resourceId;
        this.resourceTag = resourceTag;
        this.resourceUrl = resourceUrl;
        this.permisTag = permisTag;
        this.resourceName = resourceName;
    }

    public SysPermis() {
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermisTag() {
        return permisTag;
    }

    public void setPermisTag(String permisTag) {
        this.permisTag = permisTag;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
