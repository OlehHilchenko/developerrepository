package main.java.com.olehhilchenko.model.factorymethod;

import main.java.com.olehhilchenko.model.Skill;

public class SkillFactoryImpl implements SkillFactory{

    @Override
    public Skill createSkill() {
        return new Skill();
    }
}
