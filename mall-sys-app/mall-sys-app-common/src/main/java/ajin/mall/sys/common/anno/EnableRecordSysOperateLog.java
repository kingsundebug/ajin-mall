package ajin.mall.sys.common.anno;

import ajin.mall.sys.common.aspect.RecordSysOperateLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({RecordSysOperateLogAspect.class})
public @interface EnableRecordSysOperateLog {

}
