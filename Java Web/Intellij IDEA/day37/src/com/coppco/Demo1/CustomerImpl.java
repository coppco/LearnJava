package com.coppco.Demo1;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component(value = "customerImpl")
public class CustomerImpl implements Customer {

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void save() {
        log.warn("保存数据!!!");
    }

    @Override
    public void update() {
        log.warn("更新数据!!!");
    }
}
