package com.leeyumo.common.models;

import lombok.Data;

@Data
public class PageRequestWrapper<T> {
    private Integer pageNum = 1;
    private Integer pageSize = 20;
    private T bean;
}
