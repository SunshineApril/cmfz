package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.dao.MenuDao;
import gutian.wudi.cmfz.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cmfz
 * @description: MenuService实现类
 * @author: gutian
 * @create: 2018-07-05 12:50
 **/
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao med;
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public List<Menu> querryMenu() {
        List<Menu> allMenu = med.findAllMenu();

        return allMenu;
    }
}
