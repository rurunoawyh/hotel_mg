package com.hotel_mg.service;

import com.hotel_mg.base.PageResult;
import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.query.GuestRoomQuery;

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

    /**
     * 根据房间号查询客房信息
     */
    GuestRoomDO queryByRoomNum(String roomNum);

    PageResult<GuestRoomDO> query(GuestRoomQuery guestRoomQuery);
}
