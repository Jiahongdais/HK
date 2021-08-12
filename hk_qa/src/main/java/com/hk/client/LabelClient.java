package com.hk.client;

import com.hk.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Administrator
 * @create 2020/8/27 11:08
 */
@FeignClient("hk-base")
public interface LabelClient {

    @GetMapping("label/{labelId}")
    public Result findById(@PathVariable("labelId") String labelId);
}
