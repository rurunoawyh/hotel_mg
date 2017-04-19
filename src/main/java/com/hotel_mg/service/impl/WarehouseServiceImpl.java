package com.hotel_mg.service.impl;

import com.hotel_mg.ViewObject.IdName;
import com.hotel_mg.dao.WarehouseDao;
import com.hotel_mg.entity.WarehouseDO;
import com.hotel_mg.service.WarehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-wyh270612 on 2017/4/19.
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Resource
    private WarehouseDao warehouseDao;
    @Override
    public List<Object> getCodeName(String name) {
        List<WarehouseDO> warehouseDOS = warehouseDao.queryByName(name);
        ArrayList<Object> list = new ArrayList<java.lang.Object>();
        if(warehouseDOS.isEmpty()){
            return list;
        }
        for (WarehouseDO warehouseDO:warehouseDOS){
            IdName idName = new IdName();
            idName.setValue(warehouseDO.getWarehouseName());
            idName.setCode(warehouseDO.getWarehouseCode());
            list.add(idName);
        }
        return list;
    }
}
