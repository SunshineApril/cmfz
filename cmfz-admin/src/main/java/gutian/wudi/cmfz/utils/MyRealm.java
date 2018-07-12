package gutian.wudi.cmfz.utils;

import gutian.wudi.cmfz.dao.ManagerDao;
import gutian.wudi.cmfz.entity.Manager;
import gutian.wudi.cmfz.entity.SysPermis;
import gutian.wudi.cmfz.entity.SysRole;
import gutian.wudi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @program: shirodemo1
 * @description:数据源   认证和授权就都有了以后直接继承授权而不用区继承认证
 * @author: gutian
 * @create: 2018-07-11 11:57
 **/
public class MyRealm extends AuthorizingRealm {
    /**
    * @Description: 事项 AuthorizationInfo中抽象方法
    * @Param: [principalCollection]
    * @return: org.apache.shiro.authz.AuthorizationInfo
    * @Author: gutian
    * @Date: 2018.07.11
    */
    @Autowired
    private ManagerDao md;
    @Autowired
    private ManagerService ms;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        //1、获取用户信息 主身份信息就是用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //模拟数据库查到zs
        Manager managerByName = md.findManagerByName(username);
        String mgrName = managerByName.getMgrName();

        if (mgrName.equals(username)) {
            System.out.println("主身份信息"+username);
            //加入查询到了三个角色 root、admin、user
            //封装查询到的授权信息
            //模拟查询到数据库对象
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //角色
            List<SysRole> sysRoles = ms.queryRolesByUsername(username);
            for (SysRole role : sysRoles) {
                String roleTag = role.getRoleTag();
                System.out.println(roleTag);
                info.addRole(roleTag);
            }
            List<SysPermis> sysPermis = ms.queryPermisByUsername(username);
            for (SysPermis sysPermi : sysPermis) {
                String permisTag = sysPermi.getPermisTag();
                System.out.println(permisTag);
                info.addStringPermission(permisTag);

            }
//            info.addRole("root");
//            info.addRole("admin");
////            info.addRole("user");
//            info.addStringPermission("user:add");
//            info.addStringPermission("user:query");
//            info.addStringPermission("user:remove");
            //info.addRole("root");
            //这里与前台提交的进行比对
            //权限
            //info.addStringPermission("user:add");
            //返回验证信息
            return info;
        }

        return null;
    }
    /**
    * @Description: 实现AuthorizationInfo的AuthenticatingRealm父类中的认证抽象方法
    * @Param: [authenticationToken]
    * @return: org.apache.shiro.authc.AuthenticationInfo
    * @Author: gutian
    * @Date: 2018.07.11
    */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        System.out.println(username);
        Manager managerByName = md.findManagerByName(username);
        String mgrName = managerByName.getMgrName();
        if (mgrName.equalsIgnoreCase(username)) {
            //将用户信息封装到指定返回值之中
            //参数一：代表从数据库中查询得到的用户信息
            //参数二：从数据库中查询到的用户密码
            //参数三：数据源realm的名称  唯一不可重复
            //new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),UUID.randomUUID().toString());
//            if (account.isLocked()) {
//                throw new LockedAccountException("Account [" + account + "] is locked.");
//            }
//
//            if (account.isCredentialsExpired()) {
//                String msg = "The credentials for account [" + account + "] are expired";
//                throw new ExpiredCredentialsException(msg);
//            }
            //复杂验证封装
            return new SimpleAuthenticationInfo(mgrName,
                    managerByName.getMgrPwd(),
                    ByteSource.Util.bytes(managerByName.getMgrSolt()),
                    UUID.randomUUID().toString());
            //简单
            // return new SimpleAuthenticationInfo("zs","123456",);
        }
        return null;
    }
}
