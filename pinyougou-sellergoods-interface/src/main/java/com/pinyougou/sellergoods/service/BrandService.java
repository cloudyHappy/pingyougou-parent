package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 获取所有品牌
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 分页获取品牌
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum,int pageSize);

    /**
     * 条件筛选,分页查询品牌
     * @param tbBrand
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageResult findPage(TbBrand tbBrand,int currentPage,int pageSize);
    /**
     * 添加品牌
     * @param tbBrand
     */
    void add(TbBrand tbBrand);

    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    TbBrand getBrandById(long id);

    /**
     * 修改品牌信息
     * @param tbBrand
     */
    void updateBrand(TbBrand tbBrand);

    /**
     * 批量删除品牌信息
     * @param ids
     */
    void deleteBrand(long[] ids);

    /**
     * 品牌下拉框数据
     */
    List<Map> selectOptionList();
}
