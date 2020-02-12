package marco.zlc.dabl.modules.system.service;

import marco.zlc.dabl.modules.system.entity.SysUserEntity;
import org.springframework.stereotype.Service;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 2:28
 *@修改人和其它信息 UserService抽象类
 */

public interface UserService {
    SysUserEntity findByName(String name);
}
