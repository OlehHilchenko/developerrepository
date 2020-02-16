package main.java.com.olehhilchenko.view;

import java.util.Scanner;

public class ActionTips {
    public final String ENTRY_DEVELOPER_NAME = "Entry developer name: ";
    public final String ENTRY_SKILL_NAME = "Entry skill name: (to exit, entry -1)";
    public final String ENTRY_ID_REMOVABLE_DEVELOPER = "Entry ID removable developer: ";
    public final String ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_SEE = "Entry ID developer which you want to see: ";
    public final String ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_CHANGE = "Entry ID developer which you want to change: ";

    public void viewMainMenu() {
        System.out.println("Choice action: ");
        System.out.println("1. Add new Developer.");
        System.out.println("2. Update developer.");
        System.out.println("3. Delete developer.");
        System.out.println("4. View developer by ID.");
        System.out.println("5. View all developer.");
        System.out.println("6. Exit program.");
    }

    public void choiceAccountStatus() {
        System.out.println("Choice account status: ");
        System.out.println("A - ACTIVE");
        System.out.println("B - BANED");
        System.out.println("D - DELETED");
    }

    public void updateSkillMenu() {
        System.out.println("Choice action with skill: ");
        System.out.println("Delete skill - D");
        System.out.println("Save skill - S");
        System.out.println("Just enter the name of the skill to update the current Skill");
    }

    public static String scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
