package com.hotel_mg.service;

import com.hotel_mg.ViewObject.WarehouseVO;
import com.hotel_mg.base.PageResult;
import com.hotel_mg.entity.WarehouseDO;
import com.hotel_mg.query.WarehouseQuery;

import java.util.List;

/**
 * Created by wb-wyh270612 on 2017/4/19.
 */
public interface WarehouseService {
     List<Object> getCodeName(String name);

     PageResult<WarehouseVO> query(WarehouseQuery warehouseQuery) throws Exception;

     Boolean saveWarehouse(WarehouseDO warehouseDO);

     Boolean updateWarehouse(String warehouseCode);
}
