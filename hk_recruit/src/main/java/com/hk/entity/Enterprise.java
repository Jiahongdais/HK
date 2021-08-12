package com.hk.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_enterprise")
public class Enterprise {
    private String id;
    private String name;
    private String summary;
    private String address;
    private String labels;
    private String coordinate;
    private String ishot;
    private String logo;
    private int jobcount;
    private String url;
}
