package com.lazylee.study.constructor_injection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lazylee on 2017/6/21.
 */
public class AccountDaoInMemoryImpl implements AccountDao {

    private Map<Long, Account> accountMap = new HashMap<Long, Account>();
    private Account account1;
    private Account account2;
    public AccountDaoInMemoryImpl(Account account1 ,Account account2) {
        this.account1 = account1;
        this.account2 = account2;
        accountMap.put(account1.getId(), account1);
        accountMap.put(account2.getId(), account2);
    }

    /*{
            Account account1 = new Account();
            account1.setId(1L);
            account1.setOwnerName("John");
            account1.setBalance(10.0);

            Account account2 = new Account();
            account2.setId(2L);
            account2.setOwnerName("Mary");
            account2.setBalance(20.0);
            accountMap.put(account1.getId(), account1);
            accountMap.put(account2.getId(), account2);
        }*/

    public void insert(Account account) {
        accountMap.put(account.getId(), account);
    }

    public void update(Account account) {
        accountMap.put(account.getId(), account);
    }

    public void update(List<Account> accounts) {
        for (Account account : accounts) {
            accountMap.put(account.getId(), account);
        }
    }

    public void delete(Long accountId) {
        accountMap.remove(accountId);
    }

    public Account find(long accountId) {
        return accountMap.get(accountId);
    }

    public List<Account> find(List<Long> accountIds) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        for (Long id : accountIds) {
            accounts.add(accountMap.get(id));
        }
        return accounts;
    }

    public List<Account> find(String ownerName) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        for (Account account : accountMap.values()) {
            if (account.getOwnerName().equals(ownerName)) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    public List<Account> find(boolean locked) {
        List<Account> accounts = new ArrayList<Account>();
        for (Account account : accountMap.values()) {
            if (locked == account.isLocked()) {
                accounts.add(account);
            }
        }
        return accounts;
    }
}
