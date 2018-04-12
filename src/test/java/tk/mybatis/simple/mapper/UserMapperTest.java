package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest {



    @Test
    public void testSelectById() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);

            Assert.assertNotNull(user);

            Assert.assertEquals("admin", user.getUserName());

            System.out.println(user.toString());
        } finally {
            sqlSession.close();
        }
    }



    @Test
    public void testSelectAll() {

        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();

            Assert.assertNotNull(userList);

            Assert.assertTrue(userList.size() > 0);

            System.out.println(userList.toString());
        } finally {
            sqlSession.close();
        }

    }


    @Test
    public void testSelectRolesByUserId() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);

            Assert.assertNotNull(roleList);

            Assert.assertTrue(roleList.size() > 0);

            System.out.println(roleList);
        } finally {
            sqlSession.close();
        }

    }



    @Test
    public void testInsert() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = userMapper.insert(user);

            Assert.assertEquals(1, result);

            Assert.assertNull(user.getId());
        } finally {

            sqlSession.commit();

            sqlSession.close();
        }
    }


    @Test
    public void testInsert3() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = userMapper.insert3(user);

            Assert.assertEquals(1, result);

            Assert.assertNotNull(user.getId());
        } finally {

            sqlSession.commit();

            sqlSession.close();
        }
    }



    @Test
    public void testUpdateById() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("admin", user.getUserName());

            user.setUserName("admin_test");
            user.setUserEmail("test@mybatis.tk");

            int result = userMapper.updateById(user);

            Assert.assertEquals(1, result);

            user = userMapper.selectById(1L);

            Assert.assertEquals("admin_test", user.getUserName());
        } finally {

            sqlSession.rollback();
            sqlSession.close();
        }
    }



    @Test
    public void testDeleteById() {

        SqlSession sqlSession = getSqlSession();
        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user1 = userMapper.selectById(1L);

            Assert.assertNotNull(user1);


            Assert.assertEquals(1, userMapper.deleteById(1L));

            Assert.assertNull(userMapper.selectById(1L));


            SysUser user2 = userMapper.selectById(1001L);

            Assert.assertNotNull(user2);

            Assert.assertEquals(1, userMapper.deleteById(user2));

            Assert.assertNull(userMapper.selectById(1001L));
        } finally {

            sqlSession.rollback();
            sqlSession.close();
        }
    }




    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList =
                userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);

            Assert.assertNotNull(roleList);

            Assert.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }





    @Test
    public void test2Cache() {

        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user1 = userMapper.selectById(1L);


            SysUser user2 = userMapper.selectById(1L);


            Assert.assertTrue(user1 == user2);
        } finally {
            sqlSession.close();
        }
    }

}
