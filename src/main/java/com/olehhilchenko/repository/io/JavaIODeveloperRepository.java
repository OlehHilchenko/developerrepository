package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.repository.DeveloperRepository;

import java.io.FileNotFoundException;
import java.util.Map;

public class JavaIODeveloperRepository implements DeveloperRepository {
    private JavaIOUtils javaIOUtils = new JavaIOUtilsDeveloper();

    @Override
    public void insert(Developer developer) {
        try {
            Map<Long, Developer> developerMap = javaIOUtils.dataFromFile();
            developerMap.put(developer.getId(), developer);
            javaIOUtils.dataToFile(developerMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer read(Long aLong) {
        Developer developer = new Developer();
        try {
            Map<Long, Developer> developerMap = javaIOUtils.dataFromFile();
            developer = developerMap.get(aLong);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void update(Developer developer) {
        try {
            Map<Long, Developer> developerMap = javaIOUtils.dataFromFile();
            developerMap.remove(developer.getId());
            developerMap.put(developer.getId(), developer);
            javaIOUtils.dataToFile(developerMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long aLong) {
        try {
            Map<Long, Developer> developerMap = javaIOUtils.dataFromFile();
            developerMap.remove(aLong);
            javaIOUtils.dataToFile(developerMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Developer> map() {
        Map<Long, Developer> developerMap = null;
        try {
            developerMap = javaIOUtils.dataFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return developerMap;
    }
}
