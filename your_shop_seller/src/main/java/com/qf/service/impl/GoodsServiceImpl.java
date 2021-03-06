package com.qf.service.impl;

import com.qf.mapper.GoodsMapper;
import com.qf.pojo.GoodsInfo;
import com.qf.service.GoodsService;
import com.qf.vo.GoodsSelecteds;
import com.qf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    // 查询所有商品信息  商品列表页面
    public List<GoodsVo> getAllGoods(int s_id) {
        return goodsMapper.getAllGoods(s_id);
    }

    //    实现商品新增功能，1 先增加商品信息 2 再增加商品类别关系信息
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addGoodsInfo(GoodsVo goodsVo) {
        int goodsInfo = goodsMapper.addGoodsInfo(goodsVo);
//        System.out.println(goodsInfo);
        int goodsCategory = goodsMapper.addGoodsCategory(goodsVo);
//        System.out.println(goodsCategory);
        if (goodsInfo>0 && goodsCategory>0)
            return true;
        return false;
    }

    //实现商品修改功能； 1 先查询展示商品详情 2 再跟进修改的信息 修改商品信息 3 再修改商品类别关系信息
    public GoodsVo getGoodsInfoByGoodsId(int goodsId){
        GoodsVo goodsInfoByGoodsId = goodsMapper.getGoodsInfoByGoodsId(goodsId);
        return goodsInfoByGoodsId;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean uodateGoodsInfo(GoodsVo goodsVo) {
        GoodsVo goodsInfoByGoodsId = goodsMapper.getGoodsInfoByGoodsId(goodsVo.getG_id());
        int updateGoodsInfo = goodsMapper.updateGoodsInfo(goodsVo);
        if (goodsInfoByGoodsId.getChildName().equals(goodsVo.getChildName())){
            if (updateGoodsInfo>0)
                return true;
        }else {
            int updateGoodsCategory = goodsMapper.updateGoodsCategory(goodsVo);
            if (updateGoodsInfo > 0 && updateGoodsCategory > 0)
                return true;
        }
        return false;
    }

    //    根据 产品类别  修改日期区间 是否上架 还有 name title desc 关键词搜索 商品列表
    public List<GoodsVo> selectGoodsBys(GoodsSelecteds goodsSelecteds) {
        goodsSelecteds.setStr("%"+goodsSelecteds.getStr()+"%");
//        System.out.println(goodsSelecteds);
        List<GoodsVo> goodsVos = goodsMapper.selectGoodsBys(goodsSelecteds);
//        System.out.println(goodsVos);
        return goodsVos;
    }

    //根据商品id 删除商品信息
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delByGoodsId(int goodsId) {
        int delByGoodsId = goodsMapper.delByGoodsId(goodsId);
        if (delByGoodsId>0)
            return true;
        return false;
    }

    //选中删除，批量删除
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delCheckGoods(List<Integer> selectedGoodsId) {
        int delCheckGoods = goodsMapper.delCheckGoods(selectedGoodsId);
        if (delCheckGoods==selectedGoodsId.size())
            return true;
        return false;
    }

//    修改商品图片
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateIconByGId(int GId, String icon) {
        int i = goodsMapper.updateIconByGId(GId, icon);
        if (i != 0) {
            return true;
        }
        return false;
    }

}
