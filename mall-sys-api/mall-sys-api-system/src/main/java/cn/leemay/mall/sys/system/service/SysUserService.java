package cn.leemay.mall.sys.system.service;

import cn.leemay.mall.common.data.entity.system.SysUser;
import cn.leemay.mall.sys.system.form.SysUserAddForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 添加系统用户
     *
     * @param sysUserAddForm 系统用户
     */
    void add(SysUserAddForm sysUserAddForm);

    /**
     * 根据用户名获取系统用户
     *
     * @param username 用户名
     * @return 系统用户
     */
    SysUser loadUserByUsername(String username);

}
