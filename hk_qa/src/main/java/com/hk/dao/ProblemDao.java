package com.hk.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hk.entity.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProblemDao {

    /**
     * 根据标签ID查询最新问题列表
     * @param page
     * @param labelid
     * @return
     */
    @Select("select * from tb_problem,tb_pl where id = problemid and labelid = #{labelid} order by replytime desc " )
    IPage<Problem> newlist(Page<Problem> page, @Param("labelid") String labelid);

    /**
     * 根据标签ID查询最热问题列表
     * @param page
     * @param labelid
     * @return
     */
    @Select("select * from tb_problem,tb_pl where id = problemid and labelid = #{labelid} order by reply desc")
    IPage<Problem> hotlist(Page<Problem> page, @Param("labelid") String labelid);

    /**
     * 根据标签ID查询等待回答问题列表
     * @param page
     * @param labelid
     * @return
     */
    @Select("select * from tb_problem,tb_pl where id = problemid  and reply = 0 and labelid = #{labelid}  order by createtime desc")
    IPage<Problem> waitlist(Page<Problem> page, @Param("labelid") String labelid);
}
