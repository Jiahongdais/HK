package com.hk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hk.entity.Gathering;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GatheringDao extends BaseMapper<Gathering> {


}
