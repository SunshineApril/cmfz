package gutian.wudi.cmfz.entity;

/**
 * @program: cmfz
 * @description: 角色实体类
 * @author: gutian
 * @create: 2018-07-12 14:34
 **/
public class SysRole {
    private String roleId;
    private String roleName;
    private String roleTag;

    public SysRole() {
    }

    public SysRole(String roleId, String roleName, String roleTag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }
}
