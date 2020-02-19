package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.io.csvreaderandwriter.Csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaIOUtilsSkill extends JavaIOUtils<Skill> {
    private final String SKILLS_FILE_PATH = "src\\resources\\files\\skills.csv";

    @Override
    public Map<Long, Skill> dataFromFile() throws FileNotFoundException {
        Map<Long, Skill> skillMap = new HashMap<Long, Skill>();
        Csv.Reader reader = new Csv.Reader(new FileReader(SKILLS_FILE_PATH));
        List<String> stringList;
        do {
            stringList = reader.readLine();
            if (stringList != null) {
                Skill skill = new Skill();
                skill.setId(stringList.get(0));
                skill.setName(stringList.get(1));
                skillMap.put(skill.getId(), skill);
            }
        } while (stringList != null);
        reader.close();
        return skillMap;
    }

    @Override
    public void dataToFile(Map<Long, Skill> map) {
        Csv.Writer writer = new Csv.Writer(SKILLS_FILE_PATH);
        for (Long key : map.keySet()) {
            Skill skill = map.get(key);
            writer.value("" + skill.getId()).value("" + skill.getName()).newLine();
        }
        writer.close();
    }
}
