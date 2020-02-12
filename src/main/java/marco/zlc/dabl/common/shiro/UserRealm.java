package marco.zlc.dabl.common.shiro;
/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 2:35
 *@修改人和其它信息
 */

import marco.zlc.dabl.modules.system.entity.SysPermisessionEntity;
import marco.zlc.dabl.modules.system.entity.SysRoleEntity;
import marco.zlc.dabl.modules.system.entity.SysUserEntity;
import marco.zlc.dabl.modules.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm，实现授权与认证
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 用户授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===执行授权===");

        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();
        if(user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色与权限字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> premissionCollection = new HashSet<>();
            // 读取并赋值用户角色与权限
            Set<SysRoleEntity> roles = user.getRoles();
            for(SysRoleEntity role : roles){
                rolesCollection.add(role.getRole_name());
                Set<SysPermisessionEntity> permissions = role.getPermissions();
                for (SysPermisessionEntity permission : permissions){
                    premissionCollection.add(permission.getP_url());
                }
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;

    }
    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
