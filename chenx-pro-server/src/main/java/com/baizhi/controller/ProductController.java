package com.baizhi.controller;

import com.baizhi.constants.UploadPrefix;
import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin
public class ProductController {
    @Value("${upload.dir}")
    private String realPath;
    @Resource
    private ProductService productService;

    @GetMapping("queryAllPro")
    public Map<String,Object> queryAll(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "row",defaultValue = "5")int row,@RequestParam(defaultValue = "")String searchValue){
        System.out.println(searchValue);
        Map<String,Object> result=new HashMap<>();
        List<Product> products = productService.queryAllS(page, row, searchValue);
        int total = 0;
        if(products.toArray().length/5==0){
            total=products.toArray().length/5;
        }else{
            total=(products.toArray().length/5)+1;
        }
        result.put("products",products);
        result.put("total",total);
        return result;
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        //创建日期目录，方便管理文件
        String dataString = LocalDate.now().toString();
         File dateDir=new File(realPath,dataString);
         if(!dateDir.exists())dateDir.mkdirs();
         //处理上传文件的名称
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName=UUID.randomUUID().toString().replace("-","")+"."+extension;
        //处理文件的上传
        file.transferTo(new File(dateDir,newFileName));
        return UploadPrefix.IMG_URL+dataString+"/"+newFileName;
    }


    @DeleteMapping("deletePro/{id}")
    public void deletePro(@PathVariable("id") int id){
        productService.deleteS(id);
    }

    @PostMapping("insertPro")
    public void insertPro(@RequestBody Product product){
        product.setPubDate(new Date());
        System.out.println(product);
        productService.insertS(product);
    }

    @PutMapping("updatePro")
    public void updatePro(@RequestBody Product product){
        product.setPubDate(new Date());
        productService.updateS(product);
    }

}
