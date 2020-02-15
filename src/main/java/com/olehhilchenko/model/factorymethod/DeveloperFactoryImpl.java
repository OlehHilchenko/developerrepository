package main.java.com.olehhilchenko.model.factorymethod;

import main.java.com.olehhilchenko.model.Developer;

public class DeveloperFactoryImpl implements DeveloperFactory{

    @Override
    public Developer createDeveloper() {
        return new Developer();
    }
}
