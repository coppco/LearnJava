package com.coppco.Service;

import com.coppco.Dao.AccountDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;
    
    @Resource(name = "transactionTemplate")
    private TransactionTemplate transactionTemplate;

    private Logger log = Logger.getLogger(this.getClass());

    /*  使用手动编写代码的方式进行测试*/
    @Override
    public void pay(final String in, final String out, final float monery) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                    accountDao.outMonery(out, monery);
//                    int a = 1 / 0;
                    accountDao.inMonery(in,monery);


            }
        });

    }


    /**
     * 使用基于AspectJ的xml配置文件设置,  不能添加try-catch, 出现崩溃也会出现转账异常
     * @param in: 收款人
     * @param out: 付款人
     * @param monery: 金额


    @Override
    public void pay(String in, String out, float monery) {
//        try {
            accountDao.outMonery(out, monery);
            int a = 1 / 0;
            accountDao.inMonery(in,monery);
            log.warn("转账成功!!!");
//        } catch (Exception exception) {
            log.warn("转账失败!!!");
//        }
    }
     */

    /*

    @Override
    public void pay(String in, String out, float monery) {
        try {
            accountDao.outMonery(out, monery);
            int a = 1 / 0;
            accountDao.inMonery(in,monery);
            log.warn("转账成功!!!");
        } catch (Exception exception) {
            log.warn("转账失败!!!");
        }
    }

    */
}
