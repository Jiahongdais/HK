package com.hk.client;

import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR, "熔断器启动了", 0);
    }
}
