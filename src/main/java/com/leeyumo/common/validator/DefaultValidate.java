package com.leeyumo.common.validator;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class DefaultValidate implements Validate {

    private boolean pass;

    private List<ErrorBody> errorList = Lists.newArrayList();

    @Override
    public boolean pass() {
        return pass;
    }

    @Override
    public List<ErrorBody> errors() {
        return errorList;
    }


}
