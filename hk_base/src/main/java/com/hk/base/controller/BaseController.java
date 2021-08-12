package com.hk.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hk.base.pojo.Label;
import com.hk.base.service.LabelService;
import com.hk.entity.PageResult;
import com.hk.entity.Result;
import com.hk.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("label")
@CrossOrigin
@RefreshScope
public class BaseController {

    @Autowired
    private LabelService labelService;

    /**
     * 添加标签
     * @param label
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true, StatusCode.OK, "添加成功", 1);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping()
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功",labelService.findAll());
    }

    /**
     * 根据labelId查询
     * @param labelId
     * @return
     */
    @GetMapping("{labelId}")
    public Result findLabelById(@PathVariable("labelId")String labelId){
        System.out.println("No.1");
        return new Result(true, StatusCode.OK, "查询成功",labelService.findById(labelId));
    }

    /**
     * 修改标签
     * @param labelId
     * @param label
     * @return
     */
    @PutMapping("{labelId}")
    public Result update(@PathVariable("labelId")String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功", 1);
    }

    /**
     * 删除标签
     * @param labelId
     * @return
     */
    @DeleteMapping("{labelId}")
    public Result delete(@PathVariable("labelId")String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功", 1);
    }

    /**
     * 根据条件查询
     *
     * @param searchBean
     * @return
     */
    @PostMapping( "/search")
    public Result findSearch(@RequestBody Label searchBean) {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findSearch(searchBean));
    }

    /**
     * 条件+分页查询
     *
     * @param searchBean
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public Result findSearch(@RequestBody Label searchBean
            , @PathVariable int page, @PathVariable int size) {
        IPage pageList = labelService.findSearch(searchBean, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult
                (pageList.getTotal(), pageList.getRecords()));
    }
}
