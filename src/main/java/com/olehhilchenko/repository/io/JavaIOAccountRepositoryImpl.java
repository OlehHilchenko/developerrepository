package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.javenue.csv.Csv;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.factorymethod.AccountFactory;
import main.java.com.olehhilchenko.model.factorymethod.AccountFactoryImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {
    private final String csvAccountFileName = "src\\main\\resources\\files\\accounts.csv";
    private AccountFactory accountFactory = new AccountFactoryImpl();

    @Override
    public void insert(Account account) {
        try {
            List<Account> accountList = reader();
            accountList.add(account);
            writer(accountList);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    @Override
    public Account read(Long aLong) {
        List<Account> accountList = null;
        try {
            accountList = reader();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (accountList == null)
            return null;

        for (Account account : accountList) {
            if (aLong.equals(account.getId()))
                return account;
        }
        return null;
    }

    @Override
    public void update(Account account) {
        List<Account> accountList = null;
        try {
            accountList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        if (accountList == null)
            return;

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).equalsByID(account)) {
                accountList.remove(i);
                accountList.add(account);
            }
        }
        writer(accountList);
    }

    @Override
    public void remove(Long aLong) {
        List<Account> accountList = null;
        try {
            accountList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        if (accountList == null)
            return;

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId() == aLong)
                accountList.remove(i);
        }
        writer(accountList);
    }

    @Override
    public List<Account> list() {
        List<Account> accountList = null;
        try {
            accountList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return accountList;
    }

    private void writer(List<Account> accounts) {
        if (accounts == null) {
            System.out.println("JavaIOAccountRepoImpl: accounts is null");
            return;
        }
        Csv.Writer writer = new Csv.Writer(csvAccountFileName);
        for (Account account : accounts) {
            writer.value("" + account.getId()).value("" + account.getAccountStatus()).newLine();
        }
        writer.close();
    }

    private List<Account> reader() throws FileNotFoundException {
        List<Account> list = new ArrayList<Account>();

        Csv.Reader reader = new Csv.Reader(new FileReader(csvAccountFileName));
        List<String> tempList;
        while (true) {
            tempList = reader.readLine();
            if (tempList == null)
                break;

            Account account = accountFactory.createAccount();
            account.setId(tempList.get(0));
            account.setAccountStatus(tempList.get(1));
            list.add(account);
        }
        reader.close();
        return list;
    }
}
