package com.coppco.Dao;

public interface AccountDao {

    abstract public void outMonery(String out, float monery);

    abstract public void inMonery(String in, float monery);
}
