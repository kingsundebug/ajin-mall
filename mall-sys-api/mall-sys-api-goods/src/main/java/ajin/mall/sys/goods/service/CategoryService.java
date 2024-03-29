package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.CategoryAddForm;
import ajin.mall.sys.goods.form.CategoryListForm;
import ajin.mall.sys.goods.form.CategoryUpdateForm;
import ajin.mall.sys.goods.view.CategoryView;

import java.util.List;

/**
 * <p>
 * 商品类目表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface CategoryService {

    /**
     * 添加分类
     *
     * @param categoryAddForm 分类
     */
    void add(CategoryAddForm categoryAddForm);

    /**
     * 根据id删除分类
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改分类
     *
     * @param categoryUpdateForm 分类
     */
    void update(CategoryUpdateForm categoryUpdateForm);

    /**
     * 根据id查询分类
     *
     * @param id id
     * @return 分类
     */
    CategoryView get(Long id);

    /**
     * 根据条件查询分类
     *
     * @param categoryListForm 分类条件
     * @return 分类列表
     */
    ResultPage<CategoryView> list(CategoryListForm categoryListForm);

    /**
     * 树形结构查询
     *
     * @return 所有显示分类以树形结构
     */
    List<CategoryView> tree();

}
