package com.coppco.sso.service;

import com.coppco.common.pojo.TaotaoResult;
import com.coppco.pojo.TbUser;

/**
 * 检验用户数据
 */
public interface UserService {

    TaotaoResult checkUserData(String data, int type);

    TaotaoResult userRegister(TbUser user);

    TaotaoResult login(String username, String password);

    TaotaoResult getUserByToken(String token);

    TaotaoResult logoutByToken(String token);
}
