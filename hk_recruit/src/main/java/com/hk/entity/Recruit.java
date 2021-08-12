package com.hk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_recruit")
public class Recruit {
    private String  id;
    private String  jobname;
    private String  salary;
    private String  experience;
    private String  education;
    private String  type;
    private String  address;
    private String  eid;
    private Data createtime;
    private String  state;
    private String  url;
    private String  label;
    private String  content1;
    private String  content2;
}
