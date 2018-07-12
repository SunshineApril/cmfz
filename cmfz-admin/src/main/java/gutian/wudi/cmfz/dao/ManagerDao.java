package gutian.wudi.cmfz.dao;

import gutian.wudi.cmfz.entity.Manager;
import gutian.wudi.cmfz.entity.SysPermis;
import gutian.wudi.cmfz.entity.SysRole;

import java.util.List;

public interface ManagerDao {

    public Manager findManagerByName(String Name);

    List<SysRole> findRolesByUsername(String username);

    List<SysPermis> findPermisByUsername(String username);
}
