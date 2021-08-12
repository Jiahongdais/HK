package com.hk.controller;

import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import com.hk.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询热门企业
     *
     * @return
     */
    @GetMapping("search/hotlist")
    public Result hotlist() {
        return new Result(true, StatusCode.OK, "查询成功", enterpriseService.hotlist());
    }
}
