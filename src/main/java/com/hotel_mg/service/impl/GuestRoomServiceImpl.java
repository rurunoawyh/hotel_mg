package com.hotel_mg.service.impl;

import com.hotel_mg.dao.GuestRoomDao;
import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.service.GuestRoomService;
import com.hotel_mg.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
@Service
public class GuestRoomServiceImpl implements GuestRoomService {
    @Resource
    private GuestRoomDao guestRoomDao;
    @Override
    public Boolean saveGuestRoomDO(GuestRoomDO guestRoomDO) {
        String uuid = MD5Utils.getUUID();
        guestRoomDO.setId(uuid);
        //新增客房状态为空闲
        guestRoomDO.setStatus(1);
        //创建时间
        guestRoomDO.setCreateDate(new Date());
        //起始时间
        guestRoomDO.setBeginDate(new Date());
        //大小单位
        guestRoomDO.setUint("㎡");
        guestRoomDO.setPhotoUrl("");
        Integer integer = guestRoomDao.saveGuestRoomDO(guestRoomDO);
        if (integer!=null||integer==0)
            return false;
        return true;
    }

    @Override
    public GuestRoomDO queryByRoomNum(String roomNum) {
        return guestRoomDao.queryByRoomNum(roomNum);
    }
}
