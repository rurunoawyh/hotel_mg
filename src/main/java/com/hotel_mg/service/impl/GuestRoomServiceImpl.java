package com.hotel_mg.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hotel_mg.ViewObject.GuestRoomVO;
import com.hotel_mg.base.PageResult;
import com.hotel_mg.dao.GuestRoomDao;
import com.hotel_mg.dao.WarehouseDao;
import com.hotel_mg.entity.GuestRoomDO;
import com.hotel_mg.entity.WarehouseDO;
import com.hotel_mg.enums.RoomDevice;
import com.hotel_mg.enums.RoomStatusEnum;
import com.hotel_mg.enums.RoomTypeEnum;
import com.hotel_mg.query.GuestRoomQuery;
import com.hotel_mg.service.GuestRoomService;
import com.hotel_mg.util.CommonUtils;
import com.hotel_mg.util.CommonUtils.CallBack;
import com.hotel_mg.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by wb-wyh270612 on 2017/4/18.
 */
@Service
public class GuestRoomServiceImpl implements GuestRoomService {
    @Resource
    private GuestRoomDao guestRoomDao;
    @Resource
    private WarehouseDao warehouseDao;
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
        Integer integer = guestRoomDao.saveGuestRoomDO(guestRoomDO);
        if (integer!=null||integer==0)
            return false;
        return true;
    }

    @Override
    public GuestRoomDO queryByRoomNum(String roomNum) {
        return guestRoomDao.queryByRoomNum(roomNum);
    }

    @Override
    public Integer removeByRoomNum(List<String> roomNum) {
        return guestRoomDao.remove(roomNum);
    }

    @Override
    public PageResult<GuestRoomVO> query(GuestRoomQuery guestRoomQuery) throws Exception {
        PageResult<GuestRoomDO> guestRoomDOPageResult = new PageResult<>();
        List<GuestRoomDO> guestRoomDOS = guestRoomDao.queryByQuery(guestRoomQuery);
        guestRoomDOPageResult.setIndex(guestRoomQuery.getIndex());
        guestRoomDOPageResult.setList(guestRoomDOS);
        guestRoomDOPageResult.setTotalNum(guestRoomDao.count(guestRoomQuery));
        guestRoomDOPageResult.setNum(guestRoomQuery.getNum());
        ArrayList<String> codes = Lists.newArrayList();
        for (GuestRoomDO guestRoomDO:guestRoomDOS){
            codes.add(guestRoomDO.getWarehouseCode());
        }
        final Map<String, String> nameCode = getNameCode(codes);
        PageResult<GuestRoomVO> rvs = CommonUtils.dbToVo(guestRoomDOPageResult, GuestRoomVO.class, new CallBack<GuestRoomDO, GuestRoomVO>() {
            @Override
            public void execute(GuestRoomDO db, GuestRoomVO vo) {
                vo.setRoomNum(db.getRoomNum());
                vo.setRoomType(db.getRoomType());
                vo.setRoomTypeText(RoomTypeEnum.valueof(db.getRoomType()).getDesc());
                vo.setFloorNum(db.getFloorNum().toString());
                vo.setStatus(db.getStatus());
                vo.setStatusText(RoomStatusEnum.valueof(db.getStatus()).getDesc());
                vo.setId(db.getId());
                vo.setCreateDate(db.getCreateDate());
                vo.setPrivice(db.getPrivice());
                vo.setRoomArea(db.getRoomArea());
                vo.setUint(db.getUint());
                vo.setWarehouseCode(db.getWarehouseCode());
                if (!nameCode.isEmpty() && nameCode != null)
                    vo.setWarehouseName(db.getWarehouseCode() != null ? nameCode.get(db.getWarehouseCode()) : "");
                vo.setRoomDescribe(db.getRoomDescribe());
                String device = db.getDevice();
                List<Integer> list = CommonUtils.stringToList(device, Integer.class);
                //ArrayList<String> devices = Lists.newArrayList();
                String devices = "";
                for (Integer i : list) {
                    String desc = RoomDevice.valueof(i).getDesc();
                    devices += desc + ",";
                }
                vo.setRoomDevice(devices);
            }
        });

        return rvs;
    }

    private Map<String,String> getNameCode(List<String> codes){
        List<WarehouseDO> warehouseDOS = warehouseDao.queryByCodes(codes);
        HashMap<String, String> codeNameMap = Maps.newHashMap();
        for (WarehouseDO warehouseDO:warehouseDOS){
            codeNameMap.put(warehouseDO.getWarehouseCode(),warehouseDO.getWarehouseName());
        }
        return codeNameMap;
    }
}
