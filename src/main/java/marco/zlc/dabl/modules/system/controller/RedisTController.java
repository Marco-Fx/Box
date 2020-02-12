package marco.zlc.dabl.modules.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import marco.zlc.dabl.common.support.redis.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @描述
 * @创建人 zlc
 * @创建时间 2020/2/8 13:59
 * @修改人和其它信息 测试redis
 */

@Controller
@Api(tags = "对Redis进行测试")
public class RedisTController {
    @Autowired
    private RedisCacheManager redisCacheManager;

    @RequestMapping(value = "rt", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试redis", notes = "node测试redis")
    public String Rdis() {
//        redisCacheManager.set("feifei","张",19);
        Object zhang = redisCacheManager.get("zhang");
        Object FEIFEI = redisCacheManager.get("feifei");

        System.out.println(zhang.toString()+" "+FEIFEI.toString());
        return "WngSanHUO";
    }
}
