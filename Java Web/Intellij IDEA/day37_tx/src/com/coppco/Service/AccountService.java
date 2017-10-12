package com.coppco.Service;

public interface AccountService {
    /**
     * 转账
     * @param in: 收款人
     * @param out: 付款人
     * @param monery: 金额
     */
    public void pay(String in, String out, float monery);

}
