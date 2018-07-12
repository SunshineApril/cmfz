package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.entity.Manager;
import gutian.wudi.cmfz.entity.SysPermis;
import gutian.wudi.cmfz.entity.SysRole;

import java.util.List;

public interface ManagerService{

    public boolean _login(Manager m);

    List<SysRole> queryRolesByUsername(String username);

    List<SysPermis> queryPermisByUsername(String username);

}
