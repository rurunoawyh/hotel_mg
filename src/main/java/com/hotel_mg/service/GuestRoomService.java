package com.hotel_mg.service;

import com.hotel_mg.ViewObject.GuestRoomVO;
import com.hotel_mg.base.PageResult;
import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.query.GuestRoomQuery;
import java.util.List;

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

    /**
     * 修改房间状态
     * @param roomNum
     * @return
     */
    Integer removeByRoomNum(List<String> roomNum);

    /**
     *查询客房
     * @param guestRoomQuery
     * @return
     * @throws Exception
     */

    PageResult<GuestRoomVO> query(GuestRoomQuery guestRoomQuery) throws Exception;
}
