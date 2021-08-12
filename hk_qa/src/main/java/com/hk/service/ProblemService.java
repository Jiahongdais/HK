package com.hk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hk.dao.ProblemDao;
import com.hk.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    /**
     * 根据标签ID查询问题列表
     *
     * @param lableId
     * @param current
     * @param size
     * @return
     */
    public IPage<Problem> findNewListByLabelId(String lableId, int current, int size) {
        Page<Problem> page = new Page<>(current, size);
        return problemDao.newlist(page, lableId);
    }

    /**
     * 根据标签ID查询热门问题列表
     *
     * @param lableId
     * @param current
     * @param size
     * @return
     */
    public IPage<Problem> findHotListByLabelId(String lableId, int current, int size) {
        Page page = new Page(current, size);
        return problemDao.hotlist(page, lableId);
    }

    /**
     * 根据标签ID查询等待回答列表
     * @param lableId
     * @param current
     * @param size
     * @return
     */
    public IPage<Problem> findWaitListByLabelId(String lableId, int current, int size) {
        Page page = new Page(current, size);
        return problemDao.waitlist(page, lableId);
    }
}
