package com.hotel_mg.controller;

import com.hotel_mg.base.BaseController;
import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.service.GuestRoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
@RequestMapping("guestroom")
@Controller
public class GuestRoomController extends BaseController{
    @Resource
    private GuestRoomService guestRoomService;

    @RequestMapping("/save")
    public @ResponseBody Object saveGuestRoom(@Param("roomNum")String roomNum, @Param("roomType")Integer roomType, @Param("floorNum")Integer floorNum,
                         @Param("privice")Double privice, @Param("warehouseCode")String warehouseCode,
                         @Param("roomArea")Double roomArea, @Param("roomDescribe")String roomDescribe,
                         @Param("device")String device){
        GuestRoomDO guestRoomDO = null;
        try {
            checkParams(roomNum,roomDescribe,roomType,roomArea,floorNum,privice,device,warehouseCode);
            guestRoomDO = new GuestRoomDO();
            guestRoomDO.setWarehouseCode(warehouseCode);
            guestRoomDO.setDevice(device);
            guestRoomDO.setFloorNum(floorNum);
            guestRoomDO.setPrivice(privice);
            guestRoomDO.setRoomArea(roomArea);
            guestRoomDO.setRoomDescribe(roomDescribe);
            guestRoomDO.setRoomNum(roomNum);
            guestRoomDO.setRoomType(roomType);
            Boolean aBoolean = guestRoomService.saveGuestRoomDO(guestRoomDO);
            return success(aBoolean);
        } catch (Exception e) {
            return fail(e);
        }
    }

    @RequestMapping("/checkRoomNum")
    public @ResponseBody Object cheackRoomNum(@Param("roomNum")String roomNum){
        try {
            checkParams(roomNum);
            GuestRoomDO guestRoomDO = guestRoomService.queryByRoomNum(roomNum);
            if (null==guestRoomDO)
                return success(null);
            return fail(new RuntimeException("该房间号已存在！"));
        } catch (Exception e) {
            return fail(e);
        }
    }
}
