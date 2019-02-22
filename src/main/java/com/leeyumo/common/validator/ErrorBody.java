package com.leeyumo.common.validator;

import lombok.Value;

@Value
public class ErrorBody {
    private String name;
    private String msg;
}
