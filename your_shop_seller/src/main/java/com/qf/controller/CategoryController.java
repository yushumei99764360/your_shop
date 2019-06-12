package com.qf.controller;


import com.qf.mapper.CategoryMapper;
import com.qf.pojo.Category;
import com.qf.pojo.SellerInfo;
import com.qf.service.CategoryService;
import com.qf.service.GoodsService;
import com.qf.vo.CategoryVo;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // 查询所有商品类别信息  商品类别列表页面
    @RequestMapping("getAllCategory")
    public Object getAllCategory() {
        List<CategoryVo> categoryVoList = categoryService.getAllCategory();
        return categoryVoList;
    }

    //    新增商品类别信息
    @RequestMapping("addCategoryInfo")
    public boolean addCategoryInfo(@RequestBody Category category) {
        boolean addCategoryInfo = categoryService.addCategoryInfo(category);
        return addCategoryInfo;
    }

    //    实现商品类别修改功能； 1 先查询展示商品类别详情 2 再 修改商品类别信息
    // 根据商品子类类别id查询商品类别详情信息
    @RequestMapping("getCategoryById")
    public Object getCategoryById(@RequestParam int childId) {
        CategoryVo categoryById = categoryService.getCategoryById(childId);

        return categoryById;
    }

    //修改商品类别信息
    @RequestMapping("updateCategoryInfo")
    public Object updateCategoryInfo(@RequestBody CategoryVo categoryVo) {
        boolean updateCategoryInfo = categoryService.updateCategoryInfo(categoryVo);
        return updateCategoryInfo;
    }

    //    根据 关键词搜索 商品类别列表
    @RequestMapping("selectCategoryBys")
    public Object selectCategoryBys(@RequestParam String str) {
        List<CategoryVo> categoryVos = categoryService.selectCategoryBys(str);
        return categoryVos;
    }

    //根据商品子类类别id 删除商品类别信息
    @RequestMapping("delByCid")
    public Object delByCid(int childId) {
        boolean delByCid = categoryService.delByCid(childId);
        return delByCid;
    }

    // 选中删除 ，批量删除
    @RequestMapping("delCheckCategoryIds")
    public boolean delCheckCategoryIds(@RequestBody List<Integer> list) {
        boolean checkCategoryIds = categoryService.delCheckCategoryIds(list);
        return checkCategoryIds;
    }

}
