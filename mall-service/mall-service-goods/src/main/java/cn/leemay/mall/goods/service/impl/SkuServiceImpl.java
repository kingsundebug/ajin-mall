package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.goods.entity.Sku;
import cn.leemay.mall.goods.mapper.SkuMapper;
import cn.leemay.mall.goods.service.SkuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品sku表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public void insert(Sku sku) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Sku sku) {

    }

    @Override
    public Page<Sku> selectPageByCondition(Sku sku, Integer index, Integer size) {
        Page<Sku> page = new Page<>(index, size);
        QueryWrapper<Sku> queryWrapper = queryWrapper(sku);
        return skuMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Sku> selectListByCondition(Sku sku) {
        QueryWrapper<Sku> queryWrapper = queryWrapper(sku);
        return skuMapper.selectList(queryWrapper);
    }

    private QueryWrapper<Sku> queryWrapper(Sku sku) {
        QueryWrapper<Sku> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ObjectUtils.obj2Map(sku));
        return queryWrapper;
    }

}
