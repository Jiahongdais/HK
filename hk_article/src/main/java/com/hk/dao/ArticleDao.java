package com.hk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hk.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {

    /**
     * 审核
     * @param id
     */
    @Update("update tb_articel set state='1' where id = #{id}")
    public void updateStatus(@Param("id") String id);

    /**
     * 点赞
     * @param id
     */
    @Update("update tb_article set thumbup=IFNULL(thumbup,0) + 1 where id = #{id}")
    public void addThumbup(@Param("id")String id);

}
