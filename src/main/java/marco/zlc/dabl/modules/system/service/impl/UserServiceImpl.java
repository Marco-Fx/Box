package marco.zlc.dabl.modules.system.service.impl;

import marco.zlc.dabl.modules.system.dao.SysUserMapper;
import marco.zlc.dabl.modules.system.entity.SysUserEntity;
import marco.zlc.dabl.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;
    @Override
    public SysUserEntity findByName(String name) {
        // 查询用户是否存在
        SysUserEntity bean = userMapper.findByName(name);
        if (bean != null) {
            // 查询用户信息、角色、权限
            bean = userMapper.findById(bean.getUser_id());
        }
        return bean;
    }

    }

