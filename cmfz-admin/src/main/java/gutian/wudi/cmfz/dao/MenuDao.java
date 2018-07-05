package gutian.wudi.cmfz.dao;

import gutian.wudi.cmfz.entity.Menu;

import java.util.List;

/**
 * @program: cmfz
 * @description: 菜单
 * @author: gutian
 * @create: 2018-07-05 11:41
 **/
public interface MenuDao {
    public List<Menu> findAllMenu();
}
