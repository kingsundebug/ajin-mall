package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.base.util.ValidateUtils;
import cn.leemay.mall.goods.entity.dto.BrandDTO;
import cn.leemay.mall.goods.entity.vo.BrandInsertVO;
import cn.leemay.mall.goods.entity.vo.BrandSelectVO;
import cn.leemay.mall.goods.entity.vo.BrandUpdateVO;
import cn.leemay.mall.goods.service.BrandService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/goods/brand")
@Api(tags = "品牌")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加品牌")
    public BaseResult<String> insertBrand(@RequestBody @Validated BrandInsertVO brandInsertVO, BindingResult bindingResult) {
        ValidateUtils.validate(bindingResult);
        brandService.insertBrand(brandInsertVO);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除品牌", notes = "根据主键id删除")
    public BaseResult<String> deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteBrand(id);
        return new BaseResult<>(ResultCode.OK, "删除成功");
    }

    @PutMapping
    @ApiOperation(value = "修改品牌", notes = "根据主键id修改")
    public BaseResult<String> updateBrand(@RequestBody @Validated BrandUpdateVO brandUpdateVO, BindingResult bindingResult) {
        ValidateUtils.validate(bindingResult);
        brandService.updateBrand(brandUpdateVO);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<BrandDTO> selectOneById(@PathVariable("id") Long id) {
        BrandDTO result = brandService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询品牌")
    public BaseResult<List<BrandDTO>> selectListByCondition(@RequestBody BrandSelectVO brandSelectVO) {
        List<BrandDTO> result = brandService.selectListByCondition(brandSelectVO);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询品牌")
    public BaseResult<ResultPage<BrandDTO>> selectPageByCondition(@RequestBody BrandSelectVO brandSelectVO,
                                                                  @PathVariable("index") Integer index,
                                                                  @PathVariable("size") Integer size) {
        ResultPage<BrandDTO> result = brandService.selectPageByCondition(brandSelectVO, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
}

