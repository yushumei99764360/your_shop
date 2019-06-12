package com.qf.controller;

import com.qf.dto.Category;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 页面商品分类
     * @param category
     * @return
     */
    @RequestMapping(value = "categoryList",method = RequestMethod.GET)
    public Object categoryList(@RequestBody Category category) {
        List<Category> categories = categoryService.categoryList();
        System.out.println(categories);
        return categories;
    }
}
