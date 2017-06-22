package com.lazylee.study.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lazylee on 2017/6/21.
 *
 */

/* @Service he @Repository 都扩展自@Component 定义spring管理的bean */
@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
        Account sourceAccount = accountDao.find(sourceAccountId);
        Account targetAccount = accountDao.find(targetAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountDao.update(sourceAccount);
        accountDao.update(targetAccount);
    }


    public void depositMoney(long accountId, double amount)  {
        Account account = accountDao.find(accountId);
        account.setBalance(account.getBalance() + amount);
        accountDao.update(account);
    }


    public Account getAccount(long accountId) {
        return accountDao.find(accountId);
    }
}
