package com.hk.controller;

import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import com.hk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 审核
     * @param id
     * @return
     */
    @PutMapping("/examine/{id}")
    public Result examine(@PathVariable String id) {
        articleService.updateStatus(id);
        return new Result(true, StatusCode.OK, "审核成功！", 1);
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PutMapping("/thumbup/{id}")
    public Result updateThumbup(@PathVariable String id) {
        articleService.addThumbup(id);
        return new Result(true, StatusCode.OK, "点赞成功", 1);
    }

    /**
     * 根据id获取文章
     * @param id
     * @return
     */
    @GetMapping("/article/{id}")
    public Result selectArticle(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "获取文章成功", articleService.findById(id));
    }

    @GetMapping("/detele/{id}")
    public Result deleteArticle(@PathVariable String id) {
        articleService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除文章成功", 1);
    }
}
