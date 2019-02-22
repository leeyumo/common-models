package com.leeyumo.common.validator;

import java.util.List;

public interface Validate {
    boolean pass();
    List<ErrorBody> errors();
}
