package com.hotel_mg.dao;

import com.hotel_mg.entity.UserDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by D on 2017/4/9.
 */
public interface UserDao {
    Integer saveUserDO(@Param("user") UserDO userDO);

    UserDO queryByAccountNumAndJobNum(@Param("accountNum") String accountNum, @Param("jobNum") String jobNum);


}
