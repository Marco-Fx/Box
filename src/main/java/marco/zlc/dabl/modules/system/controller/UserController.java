package marco.zlc.dabl.modules.system.controller;

import marco.zlc.dabl.modules.system.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/8 2:24
 *@修改人和其它信息 用户页面跳转
 */
@Controller
public class UserController {
    /**
     * 个人中心，需认证可访问
     */
    @RequestMapping("/user/index")
    public String add(HttpServletRequest request){
        SysUserEntity bean = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("userName", bean.getUser_name());
        return "/user/index";
    }

    /**
     * 会员中心，需认证且角色为vip可访问
     */
    @RequestMapping("/vip/index")
    public String update(){
        return "/vip/index";
    }
}


