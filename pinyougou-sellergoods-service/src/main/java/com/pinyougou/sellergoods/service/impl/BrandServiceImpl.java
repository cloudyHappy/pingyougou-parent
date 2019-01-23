package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPage(TbBrand tbBrand, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize );
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(tbBrand!=null){
            if(tbBrand.getName()!=null&&tbBrand.getName().trim().length()>0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }

            if(tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().trim().length()>0){
                criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(TbBrand tbBrand) {
        checkUnique(tbBrand.getName());
        brandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand getBrandById(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBrand(TbBrand tbBrand) {
        if (!getBrandById(tbBrand.getId()).getName().equals(tbBrand.getName())) {
            //如果更改了名字,就要判断是否已经有相同的品牌名
            checkUnique(tbBrand.getName());
        }
        brandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void deleteBrand(long[] ids) {
        if (ids != null) {
            for (long id : ids) {
                brandMapper.deleteByPrimaryKey(id);
            }
        }
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }


    /**
     * 检查品牌是否已经存在
     *
     * @param name
     */
    private void checkUnique(String name) {
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<TbBrand> tbBrands = brandMapper.selectByExample(example);
        if (tbBrands.size() > 0) {
            throw new RuntimeException("该品牌已存在!");
        }
    }
}
