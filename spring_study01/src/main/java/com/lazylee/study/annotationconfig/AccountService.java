package com.lazylee.study.annotationconfig;

/**
 * Created by lazylee on 2017/6/21.
 */
public interface AccountService {
    void transferMoney(long sourceAcconutId, long targetAccountId,
                       double amount);
    void depositMoney(long accountId, double amount);
    Account getAccount(long accountId);
}
