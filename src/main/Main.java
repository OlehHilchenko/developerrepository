package main;

import main.java.com.olehhilchenko.controller.DeveloperController;
import main.java.com.olehhilchenko.javenue.csv.Csv;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.AccountStatus;
import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.io.*;
import main.java.com.olehhilchenko.repository.io.singleton.AutoIncrementUniqueID;

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

        //JavaIOAccountRepositoryImpl accountRepository = new JavaIOAccountRepositoryImpl();
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

        //SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

        //skillRepository.insert(new Skill(2l, "Fast"));
        //System.out.println(skillRepository.list().toString());

        //DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        /*
        Developer developer1 = new Developer();
        developer1.setId(12l);
        developer1.setName("dev1");
        developer1.setAccount(new Account(23l, AccountStatus.DEFAULT));
        developer1.addSkill(new Skill(33l, "first skill"));
        developer1.addSkill(new Skill(34l, "second skill"));

        Developer developer2 = new Developer();
        developer2.setId(13l);
        developer2.setName("dev2");
        developer2.setAccount(new Account(24l, AccountStatus.DEFAULT));
        developer2.addSkill(new Skill(35l, "third skill"));
        developer2.addSkill(new Skill(36l, "fourth skill"));
        */
        //List<Developer> developerList = new ArrayList<Developer>();
        //developerList.add(developer1);
        //developerList.add(developer2);

        //((JavaIODeveloperRepositoryImpl) developerRepository).writer(developerList);

        //System.out.println(((JavaIODeveloperRepositoryImpl) developerRepository).reader());
        //DeveloperRepository developerRepository = new DeveloperRepositoryFacade();
        //developerRepository.insert(developer1);
        //developerRepository.insert(developer2);

        //System.out.println(developerRepository.read(13l));
        /*
        Developer developer3 = new Developer();
        developer3.setId(15l);
        developer3.setName("dev3");
        developer3.setAccount(new Account(26l, AccountStatus.ACTIVE));
        developer3.addSkill(new Skill(38l, "fifth skill"));
        developer3.addSkill(new Skill(39l, "sixth skill"));
        developerRepository.insert(developer3);
        */
        //developerRepository.update(developer3);
        //System.out.println(developerRepository.read(13l));

        //System.out.println(developerRepository.list());
        //System.out.println(AutoIncrementUniqueID.getAutoIncrementUniqueID().getNextID());
        //System.out.println(AutoIncrementUniqueID.getAutoIncrementUniqueID().getNextID());

        DeveloperController developerController = new DeveloperController();
        System.out.println(developerController.createNewDeveloper());
    }
}
