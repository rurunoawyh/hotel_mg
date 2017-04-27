package com.hotel_mg.dao;

import com.hotel_mg.entity.WarehouseDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wb-wyh270612 on 2017/4/19.
 */
public interface WarehouseDao {
    List<WarehouseDO> queryByName(@Param("warehouseName")String warehouseName);

    List<WarehouseDO> queryByCodes(List<String> codes);
}
