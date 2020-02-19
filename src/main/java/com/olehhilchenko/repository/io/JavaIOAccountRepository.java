package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Account;

import java.io.FileNotFoundException;
import java.util.Map;

public class JavaIOAccountRepository implements AccountRepository {
    private JavaIOUtils javaIOUtils = new JavaIOUtilsAccount();

    @Override
    public void insert(Account account) {
        try {
            Map<Long, Account> accountMap = javaIOUtils.dataFromFile();
            accountMap.put(account.getId(), account);
            javaIOUtils.dataToFile(accountMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account read(Long aLong) {
        Account account = new Account();
        try {
            Map<Long, Account> accountMap = javaIOUtils.dataFromFile();
            account = accountMap.get(aLong);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        try {
            Map<Long, Account> accountMap = javaIOUtils.dataFromFile();
            accountMap.remove(account.getId());
            accountMap.put(account.getId(), account);
            javaIOUtils.dataToFile(accountMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long aLong) {
        try {
            Map<Long, Account> accountMap = javaIOUtils.dataFromFile();
            accountMap.remove(aLong);
            javaIOUtils.dataToFile(accountMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Account> map() {
        Map<Long, Account> accountMap = null;
        try {
            accountMap = javaIOUtils.dataFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return accountMap;
    }
}
