package com.qf.test;

import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import com.qf.service.GoodsService;
import com.qf.vo.CategoryVo;
import com.qf.vo.GoodsVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestCategory {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    CategoryService categoryService = context.getBean(CategoryService.class);

    @Test
    public void test1(){
        List<CategoryVo> categoryVos = categoryService.getAllCategory();

        for (CategoryVo categoryVo: categoryVos)
            System.out.println(categoryVo);
    }

    @Test
    public void test2(){
        Category category = new Category();
        category.setC_core("cs00000004");
        category.setC_name("测试类别");
        category.setC_parentid(1);
        boolean addCategoryInfo = categoryService.addCategoryInfo(category);
        System.out.println(addCategoryInfo);

    }

    @Test
    public void test3(){
        CategoryVo categoryById = categoryService.getCategoryById(31);
        System.out.println(categoryById);

    }

    @Test
    public void test4(){
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setFatherId(2);
        categoryVo.setChildName("测试02");
        categoryVo.setChildId(31);
        boolean updateCategoryInfo = categoryService.updateCategoryInfo(categoryVo);
        System.out.println(updateCategoryInfo);


    }

    @Test
    public void test5(){
        boolean delByCid = categoryService.delByCid(31);
        System.out.println(delByCid);
    }
    @Test
    public void test6(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(32);
        list.add(33);
        boolean delCheckCategoryIds = categoryService.delCheckCategoryIds(list);
        System.out.println(delCheckCategoryIds);
    }
}
