package gutian.wudi.cmfz.entity;

import java.util.List;

/**
 * @program: cmfz
 * @description: 菜单实体
 * @author: gutian
 * @create: 2018-07-05 11:27
 **/
public class Menu {
    private String menuId;
    private String menuName;
    private String menuCode;
    private String menoIcon;
    private String menuUrl;
    private String menuLevel;
    private String menuParentId;
    private List<Menu> childMenu;

    public Menu() {
    }

    public Menu(String menuId, String menuName, String menuCode, String menoIcon, String menuUrl, String menuLevel, String menuParentId, List<Menu> childMenu) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menoIcon = menoIcon;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.childMenu = childMenu;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenoIcon() {
        return menoIcon;
    }

    public void setMenoIcon(String menoIcon) {
        this.menoIcon = menoIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public List<Menu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<Menu> childMenu) {
        this.childMenu = childMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menoIcon='" + menoIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuParentId='" + menuParentId + '\'' +
                ", childMenu=" + childMenu +
                '}';
    }
}
