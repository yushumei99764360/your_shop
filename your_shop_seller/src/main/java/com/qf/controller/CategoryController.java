package com.qf.controller;



import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Category> fatherInfo = categoryService.getFatherInfo();
        categoryById.setCategoryList(fatherInfo);
        return categoryById;
    }

    //修改商品类别信息
    @RequestMapping("updateCategoryInfo")
    public Object updateCategoryInfo(@RequestBody CategoryVo categoryVo) {
        System.out.println(categoryVo);
        boolean updateCategoryInfo = categoryService.updateCategoryInfo(categoryVo);
        System.out.println(updateCategoryInfo);
        return updateCategoryInfo;
    }

    //    根据 关键词搜索 商品类别列表
    @RequestMapping("selectCategoryBys")
    public Object selectCategoryBys(@RequestParam String str) {
        System.out.println(str);
        List<CategoryVo> categoryVos = categoryService.selectCategoryBys(str);
        return categoryVos;
    }

    //根据商品子类类别id 删除商品类别信息
    @RequestMapping("delByCid")
    public boolean delByCid(int childId) {
        boolean delByCid = categoryService.delByCid(childId);
        return delByCid;
    }

    // 选中删除 ，批量删除
    @RequestMapping("delCheckCategoryIds")
    public boolean delCheckCategoryIds(@RequestBody List<Integer> selectedCId) {
        boolean checkCategoryIds = categoryService.delCheckCategoryIds(selectedCId);
        return checkCategoryIds;
    }

    // 查询所有一级类别
    @RequestMapping("getAllCategoryFather")
    public Object getAllCategoryFather(){
        List<Category> fatherInfos = categoryService.getFatherInfo();
        return fatherInfos;
    }

    // 查询所有一级类别
    @RequestMapping("getAllChildInfo")
    public Object getAllChildInfo(){
        List<Category> childInfos = categoryService.getChildInfo();
        return childInfos;
    }

    // 根据父类id 查询它所包含的所有子类信息
    @RequestMapping("getChildCategoryInfo")
    public Object getChildCategoryInfo(@RequestParam int fatherId) {
        CategoryVo categoryVo = categoryService.getChildCategoryInfo(fatherId);
        return categoryVo;
    }

    // 根据 所有父类 和 它所包含的所有子类信息
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

}
