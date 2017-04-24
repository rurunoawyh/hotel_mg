package com.hotel_mg.dao;

import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.query.GuestRoomQuery;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
public interface GuestRoomDao {
    Integer saveGuestRoomDO(GuestRoomDO guestRoomDO);

    GuestRoomDO queryByRoomNum(@Param("roomNum") String roomNum);

    List<GuestRoomDO> queryByQuery(GuestRoomQuery guestRoomQuery);

    Integer count(GuestRoomQuery guestRoomQuery);
}
