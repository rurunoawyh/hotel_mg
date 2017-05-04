package com.hotel_mg.controller;

import com.hotel_mg.base.BaseController;
import com.hotel_mg.query.WarehouseQuery;
import com.hotel_mg.service.WarehouseService;
import com.hotel_mg.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-wyh270612 on 2017/4/19.
 */
@Controller
@RequestMapping("warehouse")
public class WarehouseController extends BaseController {
    @Resource
    private WarehouseService warehouseService;

    @RequestMapping("/codeName")
    public @ResponseBody Object getCodeName(@Param("warehouseName")String warehouseName){
        try {
            List<Object> codeName = warehouseService.getCodeName(warehouseName);
            return success(codeName);
        } catch (Exception e) {
            return fail(e);
        }
    }

    @RequestMapping("/queryWarehouse")
    public @ResponseBody Object query(@Param("index")Integer index,@Param("warehouseCode")String warehouseCode,@Param("warehouseName")String warehouseName,@Param("score")Double score,
                                       @Param("createBeginDate")String createBeginDate,@Param("createEndDate")String createEndDate){
        try {
            checkParams(index);
            WarehouseQuery warehouseQuery = new WarehouseQuery();
            warehouseQuery.setIndex(index);
            warehouseQuery.setWarehouseName(warehouseName);
            warehouseQuery.setWarehouseCode(warehouseCode);
            warehouseQuery.setScore(score);
            warehouseQuery.setcreateBeginDate(org.apache.commons.lang.StringUtils.isNotBlank(createBeginDate) ? DateUtils.parseStr2DateTime(createBeginDate + " 00:00:00") : null);
            warehouseQuery.setcreateBeginDate(org.apache.commons.lang.StringUtils.isNotBlank(createEndDate) ? DateUtils.parseStr2DateTime(createEndDate + " 00:00:00") : null);
            warehouseQuery.setOrder("create_date");
            return success(warehouseService.query(warehouseQuery));
        } catch (Exception e) {
            return fail(e);
        }
    }

}
