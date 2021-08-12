package com.hk.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hk.dao.RecruitDao;
import com.hk.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 查询最新职位列表(按创建日期降序排序)
     *
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return recruitDao.selectList(Wrappers.<Recruit>lambdaQuery().eq(Recruit::getState, state).
                orderByDesc(Recruit::getCreatetime).last("limit 4"));
    }

    /**
     * 最新职位列表
     * @return
     */
    public List<Recruit> newlist() {
        return recruitDao.selectList(Wrappers.<Recruit>lambdaQuery().ne(Recruit::getState, "0").
                orderByDesc(Recruit::getCreatetime).last("limit 12"));
    }
}
