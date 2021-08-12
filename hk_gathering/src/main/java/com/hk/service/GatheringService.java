package com.hk.service;

import com.hk.dao.GatheringDao;
import com.hk.entity.Gathering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class GatheringService {

    @Autowired
    private GatheringDao gatheringDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    @Cacheable(value = "gathering",key = "#id")
    public Gathering findById(String id){
        return gatheringDao.selectById(id);
    }

    /**
     * 修改
     * @param gathering
     */
    @CacheEvict(value = "gathering",key = "#gathering.id")
    public void update(Gathering gathering){
        gatheringDao.updateById(gathering);
    }

    /**
     * 删除
     * @param id
     */
    @CacheEvict(value = "gathering",key = "#id")
    public void delete(String id){
        gatheringDao.deleteById(id);
    }
}
