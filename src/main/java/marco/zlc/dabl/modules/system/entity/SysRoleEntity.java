package marco.zlc.dabl.modules.system.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @描述
 * @创建人 zlc
 * @创建时间 2020/2/8 1:13
 * @修改人和其它信息 角色类
 */
public class SysRoleEntity implements Serializable {
    /**
     * 角色id
     */
    private int role_id;
    /**
     * 角色名
     */
    private String role_name;
    /**
     * 权限列表
     */
    private Set<SysPermisessionEntity> permissions = new HashSet<>();

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<SysPermisessionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<SysPermisessionEntity> permissions) {
        this.permissions = permissions;
    }
}
