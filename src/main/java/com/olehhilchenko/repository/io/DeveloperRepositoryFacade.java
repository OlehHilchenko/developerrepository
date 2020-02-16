package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.model.Skill;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperRepositoryFacade implements DeveloperRepository {
    private DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
    private AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();
    private SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();


    @Override
    public void insert(Developer developer) {
        developerRepository.insert(developer);
        accountRepository.insert(developer.getAccount());
        for (Skill skill : developer.getSkills()) {
            skillRepository.insert(skill);
        }
    }

    @Override
    public Developer read(Long aLong) {
        Developer developer = null;
        developer = developerRepository.read(aLong);
        developer.setAccount(accountRepository.read(developer.getAccount().getId()));
        Set<Skill> skillSet = new HashSet<Skill>();
        for (Skill skill : developer.getSkills()) {
            skillSet.add(skillRepository.read(skill.getId()));
        }
        developer.setSkills(skillSet);

        return developer;
    }

    @Override
    public void update(Developer developer) {
        developerRepository.update(developer);
        accountRepository.update(developer.getAccount());
        for (Skill skill : developer.getSkills()) {
            skillRepository.update(skill);
        }
    }

    @Override
    public void remove(Long aLong) {
        Developer developer = developerRepository.read(aLong);
        for (Skill skill : developer.getSkills()) {
            skillRepository.remove(skill.getId());
        }
        accountRepository.remove(developer.getAccount().getId());
        developerRepository.remove(aLong);
    }

    @Override
    public List<Developer> list() {
        List<Developer> developerList = developerRepository.list();
        List<Account> accountList = accountRepository.list();
        List<Skill> skillList = skillRepository.list();

        for (Developer developer : developerList) {
            for (Account account : accountList) {
                if (account.getId() == developer.getAccount().getId())
                    developer.setAccount(account);
            }
        }
        Set<Skill> skillSet = new HashSet<Skill>();
        for (Developer developer : developerList) {
            for (Skill skillFromSkillList : skillList) {
                for (Skill skill : developer.getSkills()) {
                    if (skill.equalsByID(skillFromSkillList)) {
                        skillSet.add(skillFromSkillList);
                    }
                }
            }
            developer.setSkills((Set<Skill>) ((HashSet<Skill>) skillSet).clone());
            skillSet.clear();
        }
        return developerList;
    }
}
