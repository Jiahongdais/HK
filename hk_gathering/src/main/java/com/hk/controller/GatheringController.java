package com.hk.controller;

import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import com.hk.service.GatheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatheringController {

    @Autowired
    private GatheringService gatheringService;

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    @GetMapping("/gathering/{id}")
    public Result findWaitListByLabelId(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", gatheringService.findById(id));
    }

    /**
     * 根据ID删除实体
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public Result delWaitListByLabelId(@PathVariable String id) {
        gatheringService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功", 1);
    }
}
