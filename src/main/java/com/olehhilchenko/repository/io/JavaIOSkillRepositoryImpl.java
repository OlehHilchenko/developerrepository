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
        }catch (FileNotFoundException e){
            System.err.println(e);
        }
    }

    @Override
    public Skill read(Long aLong) {
        return null;
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void remove(Long aLong) {

    }

    @Override
    public List<Skill> list() {
        List<Skill> skillList = null;
        try {
            skillList = reader();
        }catch (FileNotFoundException e){
            System.err.println(e);
        }
        return skillList;
    }

    public List<Skill> reader() throws FileNotFoundException {
        List<Skill> list = new ArrayList<Skill>();

        Csv.Reader reader = new Csv.Reader(new FileReader(csvSkillFileName));
        List<String> tempList;
        while (true){
            tempList = reader.readLine();
            if(tempList == null)
                break;

            Skill skill = skillFactory.createSkill();
            skill.setId(tempList.get(0));
            skill.setName(tempList.get(1));
            list.add(skill);
        }
        reader.close();
        return list;
    }

    public void writer(List<Skill> skills){
        if(skills == null){
            System.out.println("JavaIOSkillRepo: skills is null");
            return;
        }
        Csv.Writer writer = new Csv.Writer(csvSkillFileName);
        for(Skill skill : skills){
            writer.value("" + skill.getId()).value("" + skill.getName()).newLine();
        }
        writer.close();
    }
}
