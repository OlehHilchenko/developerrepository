package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.model.Developer;


import java.io.FileNotFoundException;
import java.util.Map;

public abstract class JavaIOUtils<T> {

    private static Long nextID;

    public static Long getNextID() {
        if (nextID == null) {
            nextID = 0l;
            DeveloperService developerService = new DeveloperService();
            Map<Long, Developer> developerMap = developerService.map();
            for (Long key : developerMap.keySet()) {
                Developer developer = developerMap.get(key);
                if (nextID < developer.getId())
                    nextID = developer.getId();
                else if (nextID < developer.getAccount().getId())
                    nextID = developer.getAccount().getId();
                for (Skill skill : developer.getSkills())
                    if (nextID < skill.getId())
                        nextID = skill.getId();
            }
            return ++nextID;
        } else
            return ++nextID;
    }

    public abstract Map<Long, T> dataFromFile() throws FileNotFoundException;

    public abstract void dataToFile(Map<Long, T> map);
}
