package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.Developer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeveloperService implements DeveloperRepository {
    private DeveloperRepository developerRepository = new JavaIODeveloperRepository();
    private AccountRepository accountRepository = new JavaIOAccountRepository();
    private SkillRepository skillRepository = new JavaIOSkillRepository();

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
        Developer developer = developerRepository.read(aLong);
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
    public Map<Long, Developer> map() {
        Map<Long, Developer> returnedMap = new HashMap<Long, Developer>();
        Developer developer;

        Map<Long, Developer> developerMap = developerRepository.map();
        Map<Long, Account> accountMap = accountRepository.map();
        Map<Long, Skill> skillMap = skillRepository.map();

        for (Long key : developerMap.keySet()) {
            developer = developerMap.get(key);
            developer.setAccount(accountMap.get(developer.getAccount().getId()));
            Set<Skill> skillSet = new HashSet<Skill>();
            for (Skill skill : developer.getSkills()) {
                skillSet.add(skillMap.get(skill.getId()));
            }
            developer.setSkills(skillSet);
            returnedMap.put(developer.getId(), developer);
        }
        return returnedMap;
    }
}
