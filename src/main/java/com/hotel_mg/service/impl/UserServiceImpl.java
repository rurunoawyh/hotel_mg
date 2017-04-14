package com.hotel_mg.service.impl;

import com.hotel_mg.dao.UserDao;
import com.hotel_mg.entity.UserDO;
import com.hotel_mg.service.UserService;
import com.hotel_mg.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by D on 2017/4/10.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public UserDO register(UserDO userDO) {
        MD5Utils.Secret secret = MD5Utils.getSecret(userDO.getPassword());
        userDO.setSalt(secret.getSalt());
        userDO.setPassword(secret.getEncryptionData());
        //员工账号状态
        userDO.setStatus(1);
        //职位
        userDO.setPosition(1);
        //所属门店
        userDO.setWarehouseCode("zz_001");
        Integer integer = userDao.saveUserDO(userDO);
        if (integer>0)
            return userDO;
        return new UserDO();
    }

    @Override
    public UserDO login(String accountNum, String password) {
        UserDO userDO = userDao.queryByAccountNumAndJobNum(accountNum,null);
        if(userDO!=null){
            if(password==userDO.getPassword())
                return userDO;
            return new UserDO();
        }else{
            return new UserDO();
        }
    }

    @Override
    public Boolean checkAccountNum(String accountNum, String jobNum) {
        UserDO userDO = userDao.queryByAccountNumAndJobNum(accountNum, jobNum);
        if(userDO!=null)
            return false;
        return true;
    }
}
