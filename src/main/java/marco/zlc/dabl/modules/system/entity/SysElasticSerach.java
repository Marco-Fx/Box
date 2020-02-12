package marco.zlc.dabl.modules.system.entity;

import marco.zlc.dabl.modules.system.entity.ElasticSerachEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/9 18:13
 *@修改人和其它信息 es的数据接口
 */
@Component
public interface SysElasticSerach extends ElasticsearchRepository<ElasticSerachEntity,Long> {

}