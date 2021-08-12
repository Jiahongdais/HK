package com.hk.controller;

import com.hk.entity.Recruit;
import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import com.hk.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @GetMapping("/search/recommend")
    public Result recommend() {
        List<Recruit> list =
                recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 最新职位列表
     * @return
     */
    @GetMapping("/search/newlist")
    public Result newlist() {
        return new Result(true, StatusCode.OK, "查询成功", recruitService.newlist());

    }
}
