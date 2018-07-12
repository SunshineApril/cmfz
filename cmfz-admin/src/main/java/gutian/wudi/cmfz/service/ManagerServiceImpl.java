package gutian.wudi.cmfz.service;


import gutian.wudi.cmfz.dao.ManagerDao;
import gutian.wudi.cmfz.entity.Manager;
import gutian.wudi.cmfz.entity.SysPermis;
import gutian.wudi.cmfz.entity.SysRole;
import gutian.wudi.cmfz.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerDao md;
    
    
    

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public boolean _login(Manager manager) {
        Manager mgr = md.findManagerByName(manager.getMgrName());
        System.out.println(mgr);
        String mgrSolt = mgr.getMgrSolt();
        System.out.println("盐"+mgrSolt);
        String finalpwd=mgrSolt+manager.getMgrPwd();
        String encryptions = EncryptionUtils.encryptions(finalpwd);
        System.out.println("加密"+encryptions);
        if (mgr.getMgrStatus()==1){
            if (mgr.getMgrPwd().equals(encryptions)){
                return true;
            }
        }else {
            System.out.println("zhanghaodongjie1");
            return false;
        }
        return false;
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public List<SysRole> queryRolesByUsername(String username) {
        return md.findRolesByUsername(username);
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public List<SysPermis> queryPermisByUsername(String username) {
        return md.findPermisByUsername(username);
    }

}
