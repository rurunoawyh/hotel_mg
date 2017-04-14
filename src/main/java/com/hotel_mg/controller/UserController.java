package com.hotel_mg.controller;

import com.hotel_mg.base.BaseController;
import com.hotel_mg.entity.UserDO;
import com.hotel_mg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by D on 2017/4/10.
 */
@RequestMapping("/user")
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("checkAccountNum")
    public @ResponseBody Object checkAccountNum(String accountNum,String jobNum){
        try {
            Boolean aBoolean = userService.checkAccountNum(accountNum, jobNum);
            return success(aBoolean);
        } catch (Exception e) {

           return fail(e);
        }
    }

    @RequestMapping("register")
    public @ResponseBody Object register(String employeeName, String jobNum, String accountNum, String password){
        try {
            if(StringUtils.isEmpty(employeeName)||StringUtils.isEmpty(jobNum)||StringUtils.isEmpty(accountNum)||StringUtils.isEmpty(password))
            {
                return new RuntimeException("必要信息不能为空");
            }
            UserDO userDO = new UserDO();
            userDO.setAccountNum(accountNum);
            userDO.setEmployeeName(employeeName);
            userDO.setJobNum(jobNum);
            userDO.setPassword(password);
            UserDO aDo = userService.register(userDO);
            if (aDo!=null)
               throw new RuntimeException("插入错误");
            return success(aDo);
        } catch (Exception e) {
            return fail(e);
        }
    }

    @RequestMapping("login")
    public @ResponseBody Object login(String accountNum,String password){
        try {
            if(StringUtils.isEmpty(accountNum)||StringUtils.isEmpty(password)){
                return new RuntimeException("账号或者密码不能为空");
            }
            UserDO userDO = userService.login(accountNum, password);
            if (userDO!=null)
                return success(userDO);
            return new RuntimeException("账号或者密码错误");
        } catch (Exception e) {
            return fail(e);
        }
    }
}
