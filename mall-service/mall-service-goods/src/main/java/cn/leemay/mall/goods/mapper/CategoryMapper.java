package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品类目表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Repository
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
