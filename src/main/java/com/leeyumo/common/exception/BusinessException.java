package com.leeyumo.common.exception;


import com.leeyumo.common.constants.BaseEnum;

/**
 * 强制业务异常必须提供code码，便于统一维护
 */
public class BusinessException extends RuntimeException {
    private final BaseEnum msg;
    private Object data;
    public BusinessException(BaseEnum msg){
        this.msg = msg;
    }
    public BusinessException(BaseEnum msg, Object data){
        this.msg = msg;
        this.data = data;
    }

    public BaseEnum getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
