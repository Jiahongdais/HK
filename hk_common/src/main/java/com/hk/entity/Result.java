package com.hk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean flag;//是否成功
    private Integer code;//返回码
    private String message;// 返回消息
    private Object data;//返回数据
}
