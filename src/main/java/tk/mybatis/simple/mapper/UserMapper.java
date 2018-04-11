package tk.mybatis.simple.mapper;

import java.util.List;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {


    /**
     *
     * 通过Id查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);




    /**
     *
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();



    /**
     *
     * 根据用户Id获取角色信息
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);




    /**
     *
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);




    /**
     *
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert2(SysUser sysUser);




    /**
     *
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert3(SysUser sysUser);
}
