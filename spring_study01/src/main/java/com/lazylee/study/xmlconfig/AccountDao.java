package com.lazylee.study.xmlconfig;

import java.util.List;

/**
 * Created by lazylee on 2017/6/21.
 */
public interface AccountDao {

    void insert(Account account);
    void update(Account account);
    void update(List<Account> accounts);
    void delete(Long accountId);
    Account find(long accountId);
    List<Account> find(List<Long> accountIds);
    List<Account> find(String ownerName);
    List<Account> find(boolean locked);
}
