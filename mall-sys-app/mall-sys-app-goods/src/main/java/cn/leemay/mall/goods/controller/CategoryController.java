package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.form.CategoryInsertForm;
import cn.leemay.mall.goods.entity.form.CategorySelectForm;
import cn.leemay.mall.goods.entity.form.CategoryUpdateForm;
import cn.leemay.mall.goods.entity.view.CategoryView;
import cn.leemay.mall.goods.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * <p>
 * 商品类目表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/goods/category")
@Api(tags = "分类")
@CrossOrigin
@Validated// todo
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加分类")
    public BaseResult<String> insertCategory(@RequestBody @Validated CategoryInsertForm categoryInsertForm) {
        categoryService.insertCategory(categoryInsertForm);
        return new BaseResult<>(ResultEnum.INSERT_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除分类", notes = "根据主键id删除")
    public BaseResult<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改分类", notes = "根据主键id修改")
    public BaseResult<String> updateCategory(@RequestBody @Validated CategoryUpdateForm categoryUpdateForm) {
        categoryService.updateCategory(categoryUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<CategoryView> selectOne(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        CategoryView result = categoryService.selectOne(id);
        if (result == null) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectList")
    @ApiOperation("根据条件查询分类")
    public BaseResult<ResultPage<CategoryView>> selectListByCondition(@RequestBody CategorySelectForm categorySelectForm) {
        ResultPage<CategoryView> result = categoryService.selectList(categorySelectForm);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @GetMapping("/selectWithTree")
    @ApiOperation("树形查询所有显示分类")
    public BaseResult<List<CategoryView>> selectWithTree() {
        List<CategoryView> result = categoryService.selectWithTree();
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }
}
