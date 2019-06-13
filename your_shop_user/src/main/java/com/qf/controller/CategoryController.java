package com.qf.controller;

import com.qf.dto.CategoryDto;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 页面商品分类
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "categoryList",method = RequestMethod.GET)
    public Object categoryList() {
        //System.out.println(1);
        //System.out.println(categories1);
        return categoryService.categoryList();
    }

    @ResponseBody
    @RequestMapping(value = "categoryListOne",method = RequestMethod.GET)
    public Object categoryListOne() {
        System.out.println(1);
        List<CategoryDto> categoryDtos = categoryService.categoryListOne();
        System.out.println(categoryDtos);
        return categoryDtos;
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
