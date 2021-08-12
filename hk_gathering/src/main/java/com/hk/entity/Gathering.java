package com.hk.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Data
@TableName("tb_gathering")
public class Gathering implements Serializable {

    private String id;
    private String name;
    private String summary;
    private String detail;
    private String sponsor;
    private String image;
    private Date starttime;
    private Date endtime;
    private String address;
    private String state;
    private String city;
}
