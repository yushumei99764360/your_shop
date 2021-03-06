package com.qf.mapper;


import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    // 查询所有商品信息  商品列表页面
    List<GoodsVo> getAllGoods(int s_id);

//    实现商品新增功能，1 先增加商品信息 2 再增加商品类别关系信息
//    新增商品信息
    int addGoodsInfo(GoodsVo goodsInfo);
//    新增商品列表关系信息
    int addGoodsCategory(GoodsVo goodsVo);

//    实现商品修改功能； 1 先查询展示商品详情 2 再跟进修改的信息 修改商品信息 3 再修改商品类别关系信息
    // 根据商品id查询商品详情信息
    GoodsVo getGoodsInfoByGoodsId(int goodsId);
    //修改商品信息
    int updateGoodsInfo(GoodsVo goodsVo);
    // 修改关系信息
    int updateGoodsCategory(GoodsVo goodsVo);

//    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表
    List<GoodsVo> selectGoodsBys(GoodsSelecteds goodsSelecteds);

    //根据商品id 删除商品信息
    int delByGoodsId(int goodsId);

    // 选中删除 ，批量删除
    int delCheckGoods(List<Integer> list);

//    上传商品图片
    int updateIconByGId(@Param("GId") int GId, @Param("icon") String icon);

}
