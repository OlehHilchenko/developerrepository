package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.javenue.csv.*;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.AccountStatus;
import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.model.factorymethod.DeveloperFactory;
import main.java.com.olehhilchenko.model.factorymethod.DeveloperFactoryImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {
    private final String csvDeveloperFileName = "src\\main\\resources\\files\\developers.csv";
    private DeveloperFactory developerFactory = new DeveloperFactoryImpl();
    private AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();
    private SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();


    @Override
    public void insert(Developer developer) {
        try {
            List<Developer> developerList = reader();
            developerList.add(developer);
            writer(developerList);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    @Override
    public Developer read(Long aLong) {
        List<Developer> developerList = null;
        try {
            developerList = reader();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        if (developerList == null)
            return null;

        for (Developer developer : developerList) {
            if (aLong.equals(developer.getId()))
                return developer;
        }
        return null;
    }

    @Override
    public void update(Developer developer) {
        List<Developer> developerList = null;
        try {
            developerList = reader();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        if (developerList == null)
            return;

        for (int i = 0; i < developerList.size(); i++) {
            if (developer.equalsById(developerList.get(i))) {
                developerList.remove(i);
                developerList.add(developer);
            }
        }
        writer(developerList);

    }

    @Override
    public void remove(Long aLong) {
        List<Developer> developerList = null;
        try {
            developerList = reader();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        if (developerList == null)
            return;

        for (int i = 0; i < developerList.size(); i++) {
            if (aLong.equals(developerList.get(i).getId()))
                developerList.remove(i);
        }
        writer(developerList);
    }

    @Override
    public List<Developer> list() {
        List<Developer> developerList = null;
        try {
            developerList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return developerList;
    }

    private void writer(List<Developer> developerList) {
        if (developerList == null) {
            System.out.println("JavaIODeveloperRepositoryImpl: developerList is null");
            return;
        }
        Csv.Writer writer = new Csv.Writer(csvDeveloperFileName);
        for (Developer developer : developerList) {
            writer.value("" + developer.getId()).value(developer.getName()).value("" + developer.getAccount().getId());
            for (Skill skill : developer.getSkills()) {
                writer.value("" + skill.getId());
            }
            writer.newLine();
        }
        writer.close();
    }

    private List<Developer> reader() throws FileNotFoundException {
        List<Developer> developerList = new ArrayList<Developer>();
        Csv.Reader reader = new Csv.Reader(new FileReader(csvDeveloperFileName));
        List<String> tempList;
        while (true) {
            tempList = reader.readLine();
            if (tempList == null)
                break;
            Developer developer = developerFactory.createDeveloper();
            for (int i = 0; i < tempList.size(); i++) {
                if (i == 0)
                    developer.setId(tempList.get(i));
                else if (i == 1)
                    developer.setName(tempList.get(i));
                else if (i == 2)
                    developer.setAccount(new Account(Long.parseLong(tempList.get(i)), AccountStatus.DEFAULT));
                else
                    developer.addSkill(new Skill(Long.parseLong(tempList.get(i)), null));
            }
            developerList.add(developer);
        }
        reader.close();
        return developerList;
    }
}
