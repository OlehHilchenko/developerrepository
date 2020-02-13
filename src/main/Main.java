package main;

import main.java.com.olehhilchenko.javenue.csv.Csv;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.AccountStatus;
import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.io.AccountRepository;
import main.java.com.olehhilchenko.repository.io.JavaIOAccountRepositoryImpl;
import main.java.com.olehhilchenko.repository.io.JavaIOSkillRepositoryImpl;
import main.java.com.olehhilchenko.repository.io.SkillRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        Account account = new Account(1254l, AccountStatus.DELETED);
        Account account2 = new Account(123456l, AccountStatus.ACTIVE);

        Csv.Writer writer = new Csv.Writer("src\\main\\resources\\files\\accounts.csv").delimiter(',');
        writer.value("" + account.getId()).value("" + account.getAccountStatus()).newLine();
        writer.value("" + account2.getId()).value("" + account2.getAccountStatus()).newLine().close();

        Account account1 = new Account();
        Csv.Reader reader = new Csv.Reader(new FileReader("src\\main\\resources\\files\\accounts.csv")).delimiter(',').ignoreComments(true);
        List<String> list = reader.readLine();
        System.out.println(list.size());
        account1.setId(Long.parseLong(list.get(0)));
        account1.setAccountStatus(list.get(1));
        System.out.println(account1.toString());
        account1.setId(0);
        account1.setAccountStatus(AccountStatus.BANNED);
        list = reader.readLine();

        account1.setId(Long.parseLong(list.get(0)));
        account1.setAccountStatus(list.get(1));
        System.out.println(account1.toString());
        list = reader.readLine();
        if (list == null)
        System.out.println("list is null");
        */

        JavaIOAccountRepositoryImpl accountRepository = new JavaIOAccountRepositoryImpl();
        /*
        List<Account> accounts1 = new ArrayList<Account>();
        accounts1.add(new Account(123456789l, AccountStatus.ACTIVE));
        accounts1.add(new Account(987654321l, AccountStatus.BANNED));
        accountRepository.writer(accounts1);

        List<Account> accounts = accountRepository.reader();
        for(Account account: accounts)
            System.out.println(account.toString());
            */

        //accountRepository.insert(new Account(1l, AccountStatus.DELETED));
        //accountRepository.update(new Account(951753l, AccountStatus.ACTIVE));
        //accountRepository.remove(951753l);
        //System.out.println(accountRepository.read(1l));
        //System.out.println(accountRepository.list().toString());

        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

        //skillRepository.insert(new Skill(2l, "Fast"));
        System.out.println(skillRepository.list().toString());
    }
}
