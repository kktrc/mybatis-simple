package tk.mybatis.simple.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
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



    /**
     *
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);



    /**
     *
     * 通过主键删除
     * @param id
     * @return
     */
    int deleteById(Long id);






    int deleteById(SysUser user);




    /**
     *
     * 根据用户id和角色的enabled状态获取用户的角色
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(
        @Param("userId") Long userId,
        @Param("enabled") Integer enabled);






    List<SysUser> selectByUser(SysUser user);






    int updateByIdSelective(SysUser user);





    int insertList(List<SysUser> userList);




    int updateByMap(Map<String, Object> map);
}
