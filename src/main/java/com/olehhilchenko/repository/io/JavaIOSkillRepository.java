package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.SkillRepository;

import java.io.FileNotFoundException;
import java.util.Map;

public class JavaIOSkillRepository implements SkillRepository {
    private JavaIOUtils javaIOUtils = new JavaIOUtilsSkill();

    @Override
    public void insert(Skill skill) {
        try {
            Map<Long, Skill> skillMap = javaIOUtils.dataFromFile();
            skillMap.put(skill.getId(), skill);
            javaIOUtils.dataToFile(skillMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill read(Long aLong) {
        Skill skill = new Skill();
        try {
            Map<Long, Skill> skillMap = javaIOUtils.dataFromFile();
            skill = skillMap.get(aLong);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void update(Skill skill) {
        try {
            Map<Long, Skill> skillMap = javaIOUtils.dataFromFile();
            skillMap.remove(skill.getId());
            skillMap.put(skill.getId(), skill);
            javaIOUtils.dataToFile(skillMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long aLong) {
        try {
            Map<Long, Skill> skillMap = javaIOUtils.dataFromFile();
            skillMap.remove(aLong);
            javaIOUtils.dataToFile(skillMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Skill> map() {
        Map<Long, Skill> skillMap = null;
        try {
            skillMap = javaIOUtils.dataFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return skillMap;
    }
}
