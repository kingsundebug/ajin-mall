package cn.leemay.mall.goods.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("品牌结果对象")
public class BrandDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌id")
    private Long id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌图片")
    private String image;

    @ApiModelProperty("首字母")
    private String initials;

    @ApiModelProperty("排序")
    private Integer sort;

}