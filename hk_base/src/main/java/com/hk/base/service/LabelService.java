package com.hk.base.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hk.base.dao.LabelDao;
import com.hk.base.pojo.Label;
import com.hk.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.selectList(null);
    }

    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.selectById(id);
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label){
        label.setId(idWorker.nextId() + "");
        labelDao.insert(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.updateById(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 条件查询
     *
     * @param searchBean
     * @return
     */
    public List<Label> findSearch(Label searchBean) {

        return labelDao.selectList(createLambdaQueryWrapper(searchBean));
    }

    /**
     * 构建查询条件
     * @param searchBean
     * @return
     */
    private LambdaQueryWrapper<Label> createLambdaQueryWrapper(Label searchBean){
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(searchBean.getLabelname())) {
            queryWrapper.like(Label::getLabelname, searchBean.getLabelname());
        }

        if (!StringUtils.isEmpty(searchBean.getState())) {
            queryWrapper.like(Label::getState, searchBean.getState());
        }

        if (!StringUtils.isEmpty(searchBean.getRecommend())) {
            queryWrapper.like(Label::getRecommend, searchBean.getRecommend());
        }
        return queryWrapper;
    }

    /**
     * 分页条件查询
     *
     * @param searchBean
     * @param page
     * @param size
     * @return
     */
    public IPage<Label> findSearch(Label searchBean, int page, int size) {
        Page<Label> lpage = new Page<>(page, size);
        IPage<Label> labelPage = labelDao.selectPage(lpage,createLambdaQueryWrapper(searchBean));
        return labelPage;
    }
}
