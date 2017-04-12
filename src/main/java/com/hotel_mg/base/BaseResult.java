package com.hotel_mg.base;

/**
 * Created by wb-xiexiaoguang.a on 2017/3/13.
 */
public class BaseResult<T> {

    private T result;

    private boolean success = true;

    private String msg;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {

        if (getSuccess() == true) {
            return null;
        }

        if (msg == null) {
            msg = "null";
        }

        return msg;
    }

    public void setMsg(Exception ex) {

        if (ex.getCause() == null) {
            this.msg = ex.getMessage();
        } else {
            this.msg = ex.getMessage() + " - " + ex.getCause();
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
