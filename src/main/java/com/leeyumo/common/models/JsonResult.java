package com.leeyumo.common.models;

import com.leeyumo.common.constants.BaseCodeMsg;
import com.leeyumo.common.constants.BaseEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public final class JsonResult<T> {
    @Setter(AccessLevel.PRIVATE)
    private Integer code;
    @Setter(AccessLevel.PRIVATE)
    private String msg;
    @Setter(AccessLevel.PRIVATE)
    private T result;

    private JsonResult(){}

    public static <E> JsonResult<E> success(E e){
        JsonResult<E> object = new JsonResult<>();
        object.setCode(BaseCodeMsg.Success.getCode());
        object.setMsg(BaseCodeMsg.Success.getName());
        object.setResult(e);
        return object;
    }

    public static <E> JsonResult<E> success(E t,String msg){
        JsonResult<E> obj = success(t);
        obj.setMsg(msg);
        return obj;
    }

    public static JsonResult fail(BaseCodeMsg baseCodeMsg){
        JsonResult object = new JsonResult();
        object.setMsg(baseCodeMsg.getName());
        object.setCode(baseCodeMsg.getCode());
        return object;
    }

    public static JsonResult fail(String msg){
        JsonResult object = new JsonResult();
        object.setMsg(msg);
        object.setCode(BaseCodeMsg.Fail.getCode());
        return object;
    }

    public static <E> JsonResult<E> fail(E e,String msg){
        JsonResult<E> object = new JsonResult<>();
        object.setCode(BaseCodeMsg.Fail.getCode());
        object.setMsg(msg);
        object.setResult(e);
        return object;
    }

    public static <E> JsonResult<E> res(BaseEnum baseCodeMsg, E t){
        JsonResult object = new JsonResult();
        object.setMsg(baseCodeMsg.getName());
        object.setCode(baseCodeMsg.getCode());
        object.setResult(t);
        return object;
    }




}
