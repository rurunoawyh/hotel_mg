package com.hotel_mg.service;

import com.hotel_mg.entity.GuestRoomDO;

/**
 * Created by D on 2017/4/10.
 */
public interface GuestRoomService {
    /**
     * 新增客房
     * @param guestRoomDO
     * @return
     */
   Boolean saveGuestRoomDO(GuestRoomDO guestRoomDO);
}