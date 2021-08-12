package com.hk.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hk.dao.EnterpriseDao;
import com.hk.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 根据热门状态获取企业列表
     *
     * @return
     */
    public List<Enterprise> hotlist() {
        LambdaQueryWrapper<Enterprise> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Enterprise::getIshot,"1");
        return enterpriseDao.selectList(lqw);
    }
}
