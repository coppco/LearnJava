package com.coppco.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class TestJedis {

    @Resource
    private JedisCluster jedisCluster;

    @Resource(name = "jedisPool")
    private JedisPool pool;
    @Test
    public void testJedis() throws Exception {
        //创建连接
        Jedis jedis = new Jedis("192.168.1.184", 6379);
        jedis.set("name", "名称");
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
    }

    @Test
    public void testJedisCluster() {
        //创建Cluster对象, 构造参数是Set类型, 每个元素是HostAndPort类型
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.1.184", 8001));
        hostAndPorts.add(new HostAndPort("192.168.1.184", 8002));
        hostAndPorts.add(new HostAndPort("192.168.1.184", 8003));
        hostAndPorts.add(new HostAndPort("192.168.1.184", 8004));
        hostAndPorts.add(new HostAndPort("192.168.1.184", 8005));
        hostAndPorts.add(new HostAndPort("192.168.1.184", 8006));
        JedisCluster cluster = new JedisCluster(hostAndPorts);
        //直接使用JedisCluster操作redis, 自带连接池, JedisCluster对象可以是单例

        cluster.set("name", "集群");

        System.out.println(cluster.get("name"));
        cluster.close();
    }

    @Test
    public void testJedisClusterSpring() {
        jedisCluster.set("name", "jedisCluster");
        System.out.println(jedisCluster.get("name"));
    }
}
