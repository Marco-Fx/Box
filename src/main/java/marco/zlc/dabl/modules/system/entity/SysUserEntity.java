package marco.zlc.dabl.modules.system.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @描述
 * @创建人 zlc
 * @创建时间 2020/2/8 1:12
 * @修改人和其它信息 用户类
 */
public class SysUserEntity implements Serializable {
    /**
     * 用户id
     */
    private Long user_id;
    /**
     * 用户名
     */
    private String user_name;
    /**
     * 用户密码
     */
    private String user_password;
    /**
     * 角色
     */
    private Set<SysRoleEntity> roles = new HashSet<>();

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Set<SysRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRoleEntity> roles) {
        this.roles = roles;
    }
}
