package marco.zlc.dabl.modules.system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 17:42
 *@修改人和其它信息 mysql connect test
 */

public interface SysTestMapper {
    List<Map> TextSel(String name);
}
