package cn.leemay.mall.common.base.util;

import cn.leemay.mall.common.base.exception.BusException;
import com.alibaba.fastjson.JSON;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ajin
 * @since 2021-05-22
 */
public class ValidateUtils {

    public static void validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
            String err = JSON.toJSONString(errMap);
            throw new BusException(err);
        }
    }
}
