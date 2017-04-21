package com.hotel_mg.query;

import com.hotel_mg.base.BaseQuery;

/**
 * Created by wb-wyh270612 on 2017/4/21.
 */
public class GuestRoomQuery extends BaseQuery{
    /**
     * 当前页
     */
    private Integer index;

    /**
     *房间类型
     */
    private Integer roomType;

    /**
     * 房间状态
     */
    private Integer status;

    /**
     * 房间号
     */
    private String roomNum;

    @Override
    public int getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
