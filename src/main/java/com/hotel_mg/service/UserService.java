package com.hotel_mg.service;

import com.hotel_mg.entity.UserDO;

/**
 * Created by D on 2017/4/10.
 */
public interface UserService {
    /**
     * 注册
     */
    UserDO register(UserDO userDO);

    /**
     * 登录
     */
    UserDO login(String accountNum, String password);

    /**
     * 检查账号
     */
    Boolean checkAccountNum(String accountNum, String jobNum);
}
