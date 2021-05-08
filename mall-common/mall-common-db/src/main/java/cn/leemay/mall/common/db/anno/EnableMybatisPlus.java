package cn.leemay.mall.common.db.anno;

import cn.leemay.mall.common.db.config.MybatisPlusConfig;
import cn.leemay.mall.common.db.handler.MyMetaObjectHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 此注解用于是否启用mybatis-plus自定义配置
 *
 * @author Ajin
 * @since 2021-04-27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MybatisPlusConfig.class, MyMetaObjectHandler.class})
public @interface EnableMybatisPlus {
}