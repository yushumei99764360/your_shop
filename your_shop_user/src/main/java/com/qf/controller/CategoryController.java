package com.qf.controller;


import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    // 查询所有一级类别
    @ResponseBody
    @RequestMapping("getAllCategoryFather")
    public Object getAllCategoryFather(){
        List<Category> fatherInfos = categoryService.getFatherInfo();
        return fatherInfos;
    }

    // 查询所有一级类别
    @ResponseBody
    @RequestMapping("getAllChildInfo")
    public Object getAllChildInfo(){
        List<Category> childInfos = categoryService.getChildInfo();
        return childInfos;
    }

    // 根据父类id 查询它所包含的所有子类信息
    @ResponseBody
    @RequestMapping("getChildCategoryInfo")
    public Object getChildCategoryInfo(@RequestParam int fatherId) {
        CategoryVo categoryVo = categoryService.getChildCategoryInfo(fatherId);
        return categoryVo;
    }

    // 根据 所有父类 和 它所包含的所有子类信息
    @ResponseBody
    @RequestMapping("getAllChildCategoryInfo")
    public Object getAllChildCategoryInfo() {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        List<Category> fatherInfo = categoryService.getFatherInfo();
        for (int i = 0 ; i<fatherInfo.size();i++){
            CategoryVo categoryVo = categoryService.getChildCategoryInfo(fatherInfo.get(i).getC_id());
            categoryVoList.add(categoryVo);
            System.out.println(categoryVo);
        }
        return categoryVoList;
    }


    /**
     * 商品信息展示
     */
    @ResponseBody
    @RequestMapping("getGoodsInfoById")
    public Object getGoodsInfoById(@RequestParam int g_id){
        return categoryService.getGoodsInfoById(g_id);
    }
}
