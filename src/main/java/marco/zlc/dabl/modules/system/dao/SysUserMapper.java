package marco.zlc.dabl.modules.system.dao;

import marco.zlc.dabl.modules.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 1:28
 *@修改人和其它信息 用户mapper
 */
@Repository
public interface SysUserMapper {
    // 查询用户信息
    SysUserEntity findByName(String name);

    // 查询用户信息、角色、权限
    SysUserEntity findById(Long id);
}
