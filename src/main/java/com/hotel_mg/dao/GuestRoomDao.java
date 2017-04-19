package com.hotel_mg.dao;

import com.hotel_mg.entity.GuestRoomDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
public interface GuestRoomDao {
    Integer saveGuestRoomDO(GuestRoomDO guestRoomDO);

    GuestRoomDO queryByRoomNum(@Param("roomNum") String roomNum);
}
