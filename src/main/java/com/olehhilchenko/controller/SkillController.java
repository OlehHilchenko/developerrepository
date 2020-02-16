package main.java.com.olehhilchenko.controller;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.model.factorymethod.SkillFactory;
import main.java.com.olehhilchenko.model.factorymethod.SkillFactoryImpl;
import main.java.com.olehhilchenko.repository.io.singleton.AutoIncrementUniqueID;
import main.java.com.olehhilchenko.view.ActionTips;

import java.util.HashSet;
import java.util.Set;


public class SkillController {

    private ActionTips actionTips = new ActionTips();
    private SkillFactory skillFactory = new SkillFactoryImpl();

    public Set<Skill> createNewSkills() {
        Set<Skill> skillSet = new HashSet<Skill>();
        String choice = "";
        while (!choice.equals("-1")) {

            System.out.println(actionTips.ENTRY_SKILL_NAME);
            choice = ActionTips.scan();
            if (!choice.equals("-1")) {
                Skill skill = skillFactory.createSkill();
                skill.setId(AutoIncrementUniqueID.getAutoIncrementUniqueID().getNextID());
                skill.setName(choice);

                skillSet.add(skill);
            }
        }
        return skillSet;
    }

    public Set<Skill> updateSkill(Set<Skill> updateSkill) {
        Set<Skill> returnedSkillSet = new HashSet<Skill>();
        String choice;
        for (Skill skill : updateSkill) {
            System.out.println("This skill - " + skill);
            actionTips.updateSkillMenu();
            choice = ActionTips.scan();
            if (choice.equals("D")) {
                continue;
            } else if (choice.equals("S")) {
                returnedSkillSet.add(skill);
            } else {
                skill.setName(choice);
                returnedSkillSet.add(skill);
            }
        }

        return returnedSkillSet;
    }
}
