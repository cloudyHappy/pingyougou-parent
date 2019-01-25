package com.pinyougou.pojogroup;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Goods implements Serializable {
    private TbGoods goods;
    private TbGoodsDesc goodsDesc;//SPU扩展信息
    private List<TbItem> itemList;//SKU列表
}
