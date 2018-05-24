package com.coppco.sso.service.impl;


import com.coppco.common.jedis.JedisClient;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.JsonUtils;
import com.coppco.mapper.TbUserMapper;
import com.coppco.pojo.TbUser;
import com.coppco.pojo.TbUserExample;
import com.coppco.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Resource(name = "jedisClientPool")
    private JedisClient jedisClient;


    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${USER_SESSION_TIME}")
    private int USER_SESSION_TIME;

    @Override
    public TaotaoResult checkUserData(String data, int type) {

        //设置查询条件
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if (type == 1) {
            //用户名
            criteria.andUsernameEqualTo(data);
        } else if (type == 2) {
            //手机号
            criteria.andPhoneEqualTo(data);
        } else if (type == 3) {
            //邮箱
            criteria.andEmailEqualTo(data);
        } else {
            return TaotaoResult.build(400, "请求数据非法");
        }
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if (null != tbUsers && tbUsers.size() > 0) {
            return TaotaoResult.ok(false);
        } else  {
            return TaotaoResult.ok(true);
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public TaotaoResult userRegister(TbUser user) {

        //用户名
        if (StringUtils.isBlank(user.getUsername())) {
            return TaotaoResult.build(400, "用户名不能为空");
        }

        TaotaoResult nameResult = checkUserData(user.getUsername(), 1);
        if (nameResult.getData() == false ) {
            return TaotaoResult.build(400, "用户名已经存在");
        }

        //密码
        if (StringUtils.isBlank(user.getPassword())) {
            return TaotaoResult.build(400, "密码不能为空");
        }

        //手机
        if (StringUtils.isBlank(user.getPhone())) {
            return TaotaoResult.build(400, "手机号不能为空");
        }

        TaotaoResult phoneResult = checkUserData(user.getPhone(), 2);
        if (phoneResult.getData() == false ) {
            return TaotaoResult.build(400, "手机号已经存在");
        }


//        //邮箱
//        if (StringUtils.isBlank(user.getEmail())) {
//            return TaotaoResult.build(400, "邮箱不能为空");
//        }
//
//        TaotaoResult emailResult = checkUserData(user.getPhone(), 3);
//        if (emailResult.getData() == false ) {
//            return TaotaoResult.build(400, "邮箱已经存在");
//        }

        //补全信息
        user.setCreated(new Date());
        user.setUpdated(new Date());

        //密码MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()).toLowerCase());

        userMapper.insert(user);

        return TaotaoResult.ok();
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public TaotaoResult login(String username, String password) {
        //用户名和密码是否正确
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> list = userMapper.selectByExample(example);

        if (null == list || list.size() == 0) {
            return TaotaoResult.build(400, "用户名或者密码错误");
        }

        TbUser user = list.get(0);
        if (!DigestUtils.md5DigestAsHex(username.getBytes()).toLowerCase().equals(user.getPassword())) {
            return TaotaoResult.build(400, "用户名或者密码错误");
        }

        //清空密码
        user.setPassword("");

        //生成Token
        String token = UUID.randomUUID().toString();
        //把用户信息保存到redis中  key为Toke  value是用户信息
        jedisClient.set(USER_SESSION + token, JsonUtils.objectToJson(user));

        //设置过期时间
        jedisClient.expire(USER_SESSION + token, USER_SESSION_TIME);
        //返回Token
        return TaotaoResult.ok(token);
    }

    /**
     * 根据token查询缓存
     * @param token
     * @return
     */
    @Override
    public TaotaoResult getUserByToken(String token) {
        String json = jedisClient.get(USER_SESSION + token);
        if (StringUtils.isBlank(json)) {
            return TaotaoResult.build(400, "用户未登录");
        }

        TbUser tbUser = JsonUtils.jsonToPojo(json, TbUser.class);
        //重置过期时间
        jedisClient.expire(USER_SESSION + token, USER_SESSION_TIME);
        return TaotaoResult.ok(tbUser);

    }

    /**
     * 根据token退出
     * @param token
     * @return
     */
    @Override
    public TaotaoResult logoutByToken(String token) {
        Boolean exists = jedisClient.exists(USER_SESSION + token);
        if (exists) {
            jedisClient.expire(USER_SESSION + token, 0);
            return TaotaoResult.ok();
        } else  {
            return TaotaoResult.build(400, "登录状态错误");
        }
    }
}
