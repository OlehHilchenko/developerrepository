package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.javenue.csv.Csv;
import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.model.factorymethod.SkillFactory;
import main.java.com.olehhilchenko.model.factorymethod.SkillFactoryImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {
    private final String csvSkillFileName = "src\\main\\resources\\files\\skills.csv";
    private SkillFactory skillFactory = new SkillFactoryImpl();

    @Override
    public void insert(Skill skill) {
        try {
            List<Skill> skillList = reader();
            skillList.add(skill);
            writer(skillList);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    @Override
    public Skill read(Long aLong) {
        List<Skill> skillList = null;
        try {
            skillList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        if (skillList == null)
            return null;

        for (Skill skill : skillList) {
            if (aLong.equals(skill.getId()))
                return skill;
        }
        return null;
    }

    @Override
    public void update(Skill skill) {
        List<Skill> skillList = null;
        try {
            skillList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        if (skillList == null)
            return;

        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).equalsByID(skill)) {
                skillList.remove(i);
                skillList.add(skill);
            }
        }
        writer(skillList);
    }

    @Override
    public void remove(Long aLong) {
        List<Skill> skillList = null;
        try {
            skillList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        if (skillList == null)
            return;
        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).getId() == aLong) {
                skillList.remove(i);
            }
        }
        writer(skillList);
    }

    @Override
    public List<Skill> list() {
        List<Skill> skillList = null;
        try {
            skillList = reader();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return skillList;
    }

    private List<Skill> reader() throws FileNotFoundException {
        List<Skill> list = new ArrayList<Skill>();

        Csv.Reader reader = new Csv.Reader(new FileReader(csvSkillFileName));
        List<String> tempList;
        while (true) {
            tempList = reader.readLine();
            if (tempList == null)
                break;

            Skill skill = skillFactory.createSkill();
            skill.setId(tempList.get(0));
            skill.setName(tempList.get(1));
            list.add(skill);
        }
        reader.close();
        return list;
    }

    private void writer(List<Skill> skills) {
        if (skills == null) {
            System.out.println("JavaIOSkillRepo: skills is null");
            return;
        }
        Csv.Writer writer = new Csv.Writer(csvSkillFileName);
        for (Skill skill : skills) {
            writer.value("" + skill.getId()).value("" + skill.getName()).newLine();
        }
        writer.close();
    }
}
