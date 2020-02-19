package main.java.com.olehhilchenko.controller;

import main.java.com.olehhilchenko.model.Skill;
import main.java.com.olehhilchenko.repository.io.JavaIOUtils;
import main.java.com.olehhilchenko.view.ActionTips;

import java.util.HashSet;
import java.util.Set;


public class SkillController {

    private ActionTips actionTips = new ActionTips();
    private final String DELETE_SKILL = "D";
    private final String SAVE_SKILL = "S";
    private final String SKILL_DELETED = "Skill deleted.";

    public Set<Skill> createNewSkills() {
        Set<Skill> skillSet = new HashSet<Skill>();
        String choice = "";
        while (!choice.equals("-1")) {

            System.out.println(actionTips.ENTRY_SKILL_NAME);
            choice = ActionTips.scan();
            if (!choice.equals("-1")) {
                Skill skill = new Skill();
                skill.setId(JavaIOUtils.getNextID());
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
            if (DELETE_SKILL.equals(choice)) {
                System.out.println(SKILL_DELETED);
            } else if (SAVE_SKILL.equals(choice)) {
                returnedSkillSet.add(skill);
            } else {
                skill.setName(choice);
                returnedSkillSet.add(skill);
            }
        }

        return returnedSkillSet;
    }
}
