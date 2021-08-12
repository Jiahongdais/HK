package com.hk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hk.entity.PageResult;
import com.hk.entity.Problem;
import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import com.hk.client.LabelClient;
import com.hk.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/newlist/{labelid}/{page}/{size}")
    public Result findNewListByLabelId(@PathVariable String
                                               labelid, @PathVariable int page, @PathVariable int size) {

        IPage<Problem> pageList =
                problemService.findNewListByLabelId(labelid, page, size);

        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotal(), pageList.getRecords());

        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 根据标签ID查询热门问题列表
     *
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/hotlist/{labelid}/{page}/{size}")
    public Result findHotListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        IPage<Problem> pageList =
                problemService.findHotListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotal(), pageList.getRecords());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 根据标签ID查询等待回答列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/waitlist/{labelid}/{page}/{size}")
    public Result findWaitListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        IPage<Problem> pageList =
                problemService.findWaitListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>
                (pageList.getTotal(), pageList.getRecords());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    @Autowired
    private LabelClient labelClient;

    @RequestMapping(value = "/label/{labelid}")
    public Result findLabelById(@PathVariable String labelid){
        Result result = labelClient.findById(labelid);
        return result;
    }
}
