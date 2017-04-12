package com.hotel_mg.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpSession session;
    @Resource
    protected HttpServletResponse response;
    /**
     * 获取用户id
     *
     * @return
     * @throws Exception
     */

    protected String getSessionWarehouseCode(){
        return session.getAttribute("warehouseCode").toString();
    }


    protected <T> BaseResult<T> success(T t) {

        BaseResult<T> res = new BaseResult<T>();
        res.setSuccess(true);
        res.setMsg("");
        res.setResult(t);
        return res;
    }

    protected <T> BaseResult<T> fail(Exception e) {

        BaseResult<T> res = new BaseResult<T>();
        res.setMsg(e.getMessage());
        res.setSuccess(false);
        return res;
    }

    /**
     * 必要参数检查
     *
     * @param params
     */
    public void checkParams(Object... params) {

        for (Object o : params) {
            if(o==null||o==""){
                throw  new RuntimeException("必要参数不存在");
            }
        }
    }
    protected Date getDate(String beginDate,String pattern) throws Exception {
        SimpleDateFormat sdf =  new SimpleDateFormat();
        sdf.applyPattern(pattern==null?"yyyy-MM-dd":pattern);
        return sdf.parse(beginDate);
    }
}
