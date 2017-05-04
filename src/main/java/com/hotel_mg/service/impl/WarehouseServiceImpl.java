package com.hotel_mg.service.impl;

import com.hotel_mg.ViewObject.IdName;
import com.hotel_mg.ViewObject.WarehouseVO;
import com.hotel_mg.base.PageResult;
import com.hotel_mg.dao.WarehouseDao;
import com.hotel_mg.entity.WarehouseDO;
import com.hotel_mg.query.WarehouseQuery;
import com.hotel_mg.service.WarehouseService;
import com.hotel_mg.util.CommonUtils;
import com.hotel_mg.util.CommonUtils.CallBack;
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

    @Override
    public PageResult<WarehouseVO> query(WarehouseQuery warehouseQuery) throws Exception {
        List<WarehouseDO> warehouseDOS = warehouseDao.query(warehouseQuery);
        Integer count = warehouseDao.count(warehouseQuery);
        PageResult<WarehouseDO> warehouseDOPageResult = PageResult.create(warehouseDOS, warehouseQuery.getIndex(), warehouseQuery.getNum(), count);
        PageResult<WarehouseVO> voPageResult = CommonUtils.dbToVo(warehouseDOPageResult, WarehouseVO.class, new CallBack<WarehouseDO, WarehouseVO>() {
            @Override
            public void execute(WarehouseDO db, WarehouseVO vo) {
                 vo.setWarehouseMg(db.getUserId());
            }
        });
        return voPageResult;
    }
}
