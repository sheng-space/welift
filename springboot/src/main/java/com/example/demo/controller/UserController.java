package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import com.example.demo.token.NoLogin;
import com.example.demo.util.BaseTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 * redis
 * @author sheng
 * @date 2019/11/21
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseTool {

    @Resource
    private UserService userService;
    @Resource
    private LoginService loginService;


    @RequestMapping(value = "/login")
    @ResponseBody
    @NoLogin
    public String login(String phone,String password) {
        //管理员登录哦其他的用手机号码
        if(phone.equals("admin")||phone.equals("Admin")){
            phone = "18378946745";
            password = "123456";
        }

        Map loginInfo = loginService.login(phone,password);
        if(loginInfo==null){
            return outError("账号密码错误");
        }

        return outSuccess(loginInfo);
    }


}
