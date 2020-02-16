package main.java.com.olehhilchenko.repository.io.singleton;

import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.io.DeveloperRepositoryFacade;

import java.util.List;

public class AutoIncrementUniqueID {
    private static AutoIncrementUniqueID autoIncrementUniqueID;
    private static Long nextID;

    private AutoIncrementUniqueID() {
    }

    public static AutoIncrementUniqueID getAutoIncrementUniqueID() {
        if (autoIncrementUniqueID == null) {
            autoIncrementUniqueID = new AutoIncrementUniqueID();
            return autoIncrementUniqueID;
        }
        return autoIncrementUniqueID;
    }

    public Long getNextID() {
        if (nextID == null) {
            nextID = 0l;
            DeveloperRepositoryFacade developerRepositoryFacade = new DeveloperRepositoryFacade();
            List<Developer> developerList = developerRepositoryFacade.list();
            for (Developer developer : developerList) {
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
}
