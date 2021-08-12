package com.hk.service;

import com.hk.dao.ArticleDao;
import com.hk.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 文章审核
     * @param id
     */
    public void updateStatus(String  id){
        articleDao.updateStatus(id);
    }

    /**
     * 点赞
     * @param id
     */
    public void addThumbup(String  id){
        articleDao.addThumbup(id);
    }

    /**
     * 根据id获取文章
     * @param id
     * @return
     */
    public Article findById(String id){
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        if (article==null){
            article = articleDao.selectById(id);
            redisTemplate.opsForValue().set("article_" + id, article,10, TimeUnit.SECONDS);
        }
        return article;
    }

    /**
     * 修改
     * @param article
     */
    public void update(Article article) {
        redisTemplate.delete("article_" + article.getId());//删除缓存
        articleDao.updateById(article);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        redisTemplate.delete("article_" + id);//删除缓存
        articleDao.deleteById(id);
    }
}
