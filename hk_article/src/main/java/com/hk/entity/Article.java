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
@TableName("tb_article")
public class Article implements Serializable {

    private String id;
    private String columnid;
    private String userid;
    private String title;
    private String content;
    private String image;
    private Date createtime;
    private Date updatetime;
    private String ispublic;
    private String istop;
    private int visits;
    private int thumbup;
    private int comment;
    private String state;
    private int channelid;
    private String url;
    private String type;
}
