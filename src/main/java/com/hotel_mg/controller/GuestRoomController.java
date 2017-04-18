package com.hotel_mg.controller;

import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.service.GuestRoomService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
@RequestMapping("guestroom")
public class GuestRoomController {
    @Resource
    private GuestRoomService guestRoomService;

    @RequestMapping("/save")
    public Object saveGuestRoom(GuestRoomDO guestRoomDO){
        return guestRoomService.saveGuestRoomDO(guestRoomDO);
    }
}
