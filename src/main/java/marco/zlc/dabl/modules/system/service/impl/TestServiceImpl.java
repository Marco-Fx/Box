package marco.zlc.dabl.modules.system.service.impl;

import marco.zlc.dabl.modules.system.dao.SysTestMapper;
import marco.zlc.dabl.modules.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 17:43
 *@修改人和其它信息 实现
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private SysTestMapper sysTestMapper;
    @Override
    public List<Map> TextSel(String name) {
        return sysTestMapper.TextSel(name);
    }
}
