package com.baizhi.controller;

import com.baizhi.entity.CateGory;
import com.baizhi.service.CateGoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class CateGoryController {
    @Resource
    private CateGoryService cateGoryService;

    @GetMapping("/allCateGory")
    public List<CateGory> queryAll(){
        return cateGoryService.queryAllS();
    }

    @PostMapping("/insertCateGory")
    public void insert(@RequestBody CateGory cateGory){
        cateGoryService.insertS(cateGory);
    }

    @DeleteMapping("/deleteCateGory/{id}")
    public void delete(@PathVariable("id") int id){
        cateGoryService.deleteS(id);
    }

    @PutMapping("/updateCateGory")
    public void updateCateGory(@RequestBody CateGory cateGory){
        System.out.println(cateGory);
        cateGoryService.updateS(cateGory);
    }
}
