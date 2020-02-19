package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.io.csvreaderandwriter.Csv;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.Developer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class JavaIOUtilsDeveloper extends JavaIOUtils<Developer> {
    private final String DEVELOPERS_FILE_PATH = "src\\resources\\files\\developers.csv";

    @Override
    public Map<Long, Developer> dataFromFile() throws FileNotFoundException {
        Map<Long, Developer> developerMap = new HashMap<Long, Developer>();
        Csv.Reader reader = new Csv.Reader(new FileReader(DEVELOPERS_FILE_PATH));
        List<String> stringList;
        do {
            stringList = reader.readLine();
            if (stringList != null) {
                Developer developer = new Developer();
                Account account = new Account();
                Set<Skill> skillSet = new HashSet<Skill>();


                developer.setId(stringList.get(0));
                stringList.remove(0);
                developer.setName(stringList.get(0));
                stringList.remove(0);
                account.setId(stringList.get(0));
                stringList.remove(0);
                developer.setAccount(account);
                for (String s : stringList) {
                    Skill skill = new Skill();
                    skill.setId(s);
                    skillSet.add(skill);
                }
                developer.setSkills(skillSet);
                developerMap.put(developer.getId(), developer);
            }
        } while (stringList != null);
        reader.close();
        return developerMap;
    }

    @Override
    public void dataToFile(Map<Long, Developer> map) {
        Csv.Writer writer = new Csv.Writer(DEVELOPERS_FILE_PATH);
        for (Long key : map.keySet()) {
            Developer developer = map.get(key);
            writer.value("" + developer.getId()).value("" + developer.getName()).value("" + developer.getAccount().getId());
            for (Skill skill : developer.getSkills()) {
                writer.value("" + skill.getId());
            }
            writer.newLine();
        }
        writer.close();
    }
}
