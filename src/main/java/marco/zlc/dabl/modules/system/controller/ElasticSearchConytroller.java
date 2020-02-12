package marco.zlc.dabl.modules.system.controller;

import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import marco.zlc.dabl.modules.system.entity.ElasticSerachEntity;
import marco.zlc.dabl.modules.system.entity.SysElasticSerach;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @描述
 * @创建人 zlc
 * @创建时间 2020/2/9 18:19
 * @修改人和其它信息 EsController
 */
@Api(tags = "ESController")
@RestController
public class ElasticSearchConytroller {
    Logger logger = LogManager.getLogger(ElasticSearchConytroller.class);
    @Autowired
    SysElasticSerach elasticsearchRepository;

    @ApiOperation(value = "将数据保存到ES内")
    @GetMapping("/search/all")
    public String loadAllUser() {
        ElasticSerachEntity en = new ElasticSerachEntity();
        //简单的引用
        en.setUserName("zhang");
        en.setMail("57148400@qq.com");
        logger.info("es");

        elasticsearchRepository.save(en);
        return "111";
    }
    @ApiOperation(value = "查询")
    @ResponseBody
    @GetMapping("/search/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name, Pageable pageable) {

        //按name进行搜索
        MatchQueryBuilder builder = QueryBuilders.matchQuery("userName", name);

        //如果实体和数据的名称对应就会自动封装，pageable分页参数
        Page<ElasticSerachEntity> users = elasticsearchRepository.search(builder, pageable);
        logger.info("搜索成功");
        //迭代器转list
        ArrayList<ElasticSerachEntity> list = Lists.newArrayList(users);
        return ResponseEntity.ok(list);
    }
}
