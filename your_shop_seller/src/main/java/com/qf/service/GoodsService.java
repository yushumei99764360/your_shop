package com.qf.service;

import com.qf.pojo.GoodsInfo;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    // 查询所有商品信息  商品列表页面
    List<GoodsVo> getAllGoods(int s_id);

    //    实现商品新增功能，1 先增加商品信息 2 再增加商品类别关系信息
    boolean addGoodsInfo(GoodsVo goodsVo);

    //    实现商品修改功能； 1 先查询展示商品详情 2 再跟进修改的信息 修改商品信息 3 再修改商品类别关系信息
    GoodsVo getGoodsInfoByGoodsId(int goodsId);
    boolean uodateGoodsInfo(GoodsVo goodsVo);

    //    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表
    List<GoodsVo> selectGoodsBys(GoodsSelecteds goodsSelecteds);

    //根据商品id 删除商品信息
    boolean delByGoodsId(int goodsId);

    // 选中删除，批量删除
    boolean delCheckGoods(List<Integer> selectedGoodsId);
//    上传图片
    boolean updateIconByGId(int GId, String icon);
}
