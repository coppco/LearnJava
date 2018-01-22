package com.coppco.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class JedisTest {

    @Resource(name = "jedisPool")
    private JedisPool pool;

    @Test
    public void testJedis() throws Exception {
        //创建连接
        Jedis jedis = new Jedis("192.168.1.184", 6379);

        jedis.set("name", "向弘杰");

        System.out.println(jedis.get("name"));

        jedis.close();
    }

    @Test
    public void testJedisPool() throws Exception {
        //创建连接池
        JedisPool pool = new JedisPool("192.168.1.184", 6379);

        Jedis jedis = pool.getResource();

        jedis.set("name", "向弘杰");

        System.out.println(jedis.get("name"));

        jedis.close();
    }

    @Test
    public void testSpringJedisPool() {
        Jedis jedis = pool.getResource();

        jedis.set("name", "名称");

        System.out.println(jedis.get("name"));

        jedis.close();
    }
}
