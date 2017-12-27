package com.coppco.test;


import com.coppco.HJLog.HJLog;
import com.coppco.mapper.UserMapper;
import com.coppco.pojo.Orders;
import com.coppco.pojo.QueryVo;
import com.coppco.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MyTest {

    @Test
    public void findUserById() throws Exception {
        //通过核心配置文件输入流创建 会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        //创建会话
        SqlSession sqlSession = factory.openSession();

        /**
         * 第一个参数 :  namespace+sql的id
         * 第二个参数: 传入的参数
         */
        User one = (User) sqlSession.selectOne("test.fingUserById", 1);

        HJLog.logger.info(one);

        sqlSession.close();
    }

    @Test
    public void findUserByUserName() throws Exception {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = factory.openSession();

        List<Object> list = sqlSession.selectList("test.fingUserByUserName", "王");

        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            HJLog.logger.debug(it.next());
        }
        sqlSession.close();
    }

    @Test
    public void insertUser() throws Exception {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = factory.openSession();
        User user = new User();
        user.setAddress("123");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setUsername("张三");
        sqlSession.insert("test.insetUser", user);
        sqlSession.commit();
        sqlSession.close();

        HJLog.logger.debug(user.getId());

    }

    private SqlSessionFactory factory;

    @Before
    public void setup() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void testMapper() throws Exception {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.fingUserById(10);

        HJLog.logger.info(user);
    }



    @Test
    public void testMapperList() throws Exception {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByUsername("王");

        HJLog.logger.info(list);
    }

    @Test
    public void testMapperInsert() throws Exception {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("熊大");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("杭州市");
        mapper.insetUser(user);

        sqlSession.commit();
    }

    @Test
    public void testMapperVo() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("小");
        user.setSex("1");
        vo.setUser(user);
        List<User> userByVo = mapper.findUserByVo(vo);

        HJLog.logger.info(userByVo);
    }

    @Test
    public void testMapperByCount() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Long userCount = mapper.findUserCount();

        HJLog.logger.info(userCount);
    }

    @Test
    public void testMapperByUsernameAndSex() throws Exception {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user = new User();
        user.setUsername("小");
        user.setSex("1");

        List<User> userByVo = mapper.findUserByUsernameAndSex(user);

        HJLog.logger.info(userByVo);
    }

    @Test
    public void testMapperFindOrdersAndUsers() throws Exception{
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Orders> ordersAndUsers = mapper.findOrdersAndUsers();


        HJLog.logger.debug(ordersAndUsers);
    }

    @Test
    public void testMapperFindUsersAndOrders() throws Exception{
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = mapper.findUserAndOrders();
        HJLog.logger.debug(list);
    }
}
