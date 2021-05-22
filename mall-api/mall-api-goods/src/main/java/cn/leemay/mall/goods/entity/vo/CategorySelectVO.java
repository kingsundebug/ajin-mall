package cn.leemay.mall.goods.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("分类查询对象")
public class CategorySelectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    private Long id;

    @ApiModelProperty("上级id")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类级别")
    private Integer level;

    @ApiModelProperty("是否显示")
    private Integer isShow;

}
