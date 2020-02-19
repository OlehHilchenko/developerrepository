package main.java.com.olehhilchenko.controller;

        import main.java.com.olehhilchenko.model.Developer;
        import main.java.com.olehhilchenko.repository.io.JavaIOUtils;
        import main.java.com.olehhilchenko.view.ActionTips;

public class DeveloperController {
    private ActionTips actionTips = new ActionTips();
    private AccountController accountController = new AccountController();
    private SkillController skillController = new SkillController();

    public Developer createNewDeveloper() {
        Developer developer = new Developer();
        developer.setId(JavaIOUtils.getNextID());

        System.out.println(actionTips.ENTRY_DEVELOPER_NAME);
        developer.setName(ActionTips.scan());

        developer.setAccount(accountController.createNewAccount());
        developer.setSkills(skillController.createNewSkills());

        return developer;
    }

    public Developer updateDeveloper(Developer updateDeveloper) {

        System.out.println(actionTips.ENTRY_DEVELOPER_NAME);
        updateDeveloper.setName(ActionTips.scan());

        updateDeveloper.setAccount(accountController.updateAccount(updateDeveloper.getAccount()));
        updateDeveloper.setSkills(skillController.updateSkill(updateDeveloper.getSkills()));

        return updateDeveloper;
    }
}
