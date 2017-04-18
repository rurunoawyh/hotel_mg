package com.hotel_mg.service.impl;

import com.hotel_mg.dao.GuestRoomDao;
import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.service.GuestRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
@Service
public class GuestRoomServiceImpl implements GuestRoomService {
    @Resource
    private GuestRoomDao guestRoomDao;
    @Override
    public Boolean saveGuestRoomDO(GuestRoomDO guestRoomDO) {
        Integer integer = guestRoomDao.saveGuestRoomDO(guestRoomDO);
        if (integer!=null||integer==0)
            return false;
        return true;
    }
}
