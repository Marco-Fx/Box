package marco.zlc.dabl.modules.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import marco.zlc.dabl.common.support.activemq.MqProducer;
import marco.zlc.dabl.modules.system.entity.SysUserEntity;
import marco.zlc.dabl.modules.system.service.UserService;
import marco.zlc.dabl.modules.system.service.impl.TestServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@Api(tags = "登录")
public class Test {
    @Autowired
    private TestServiceImpl testService;
    @Autowired
    private MqProducer mqProducer;

    Logger logger = LogManager.getLogger(Test.class);//使用日志

    @RequestMapping(value = "zhang/{name}", method = {RequestMethod.GET})
    @ApiOperation(value = "根据参数获取名字", notes = "查询redis中的记录", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "用户的昵称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "id", value = "用户的ID", paramType = "query", dataType = "Integer", required = true)
    })
    public String zhang(@PathVariable("name") String name) {
        List<Map> maps = testService.TextSel(name);
        for (int i = 0; i < 100; i++) {
            mqProducer.sendStringQueue("111111", "十三亲");
        }

        logger.debug("对@PathVariable的测试，以及swagger的使用");
        System.out.println("成功");
        System.out.println(maps);
        return "Tesaat";
    }
}
