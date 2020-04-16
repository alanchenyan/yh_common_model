package com.yh.common.model.user.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @program: real_estate
 * @description: 基类
 * @author: David
 * @create: 2020-04-02 18:50
 **/
public class BaseController<T, S extends Page> {

    @Autowired
    IBaseService<T, S> iBaseService;

    @ApiOperation("新增")
    @PostMapping
    public void addData(@RequestBody @Valid T t) {

        iBaseService.addData(t);

    }

    @ApiOperation("修改")
    @PutMapping
    public void updateData(@RequestBody @Valid T t) {

        iBaseService.updateData(t);
    }

    @ApiOperation("获取")
    @GetMapping("/{id}")
    public T getData(@PathVariable String id) {

        return iBaseService.getData(id);
    }


    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable String id) {

        iBaseService.deleteData(id);
    }

    @ApiOperation("分页查询")
    @GetMapping("/list")
    public IPage<T> pageData(@Valid S s) {

        return iBaseService.pageData(s);
    }

}
