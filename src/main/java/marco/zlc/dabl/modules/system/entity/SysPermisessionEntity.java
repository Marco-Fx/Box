package marco.zlc.dabl.modules.system.entity;

import java.io.Serializable;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 1:13
 *@修改人和其它信息 权限类
  */
public class SysPermisessionEntity implements Serializable {
    /**
     * 权限id
     */
    private int p_id;
    /**
     * 权限名
     */
    private String p_name;
    /**
     * 权限路径
     */
    private String p_url;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }
}
