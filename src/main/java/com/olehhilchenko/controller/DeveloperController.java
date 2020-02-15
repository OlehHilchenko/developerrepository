package main.java.com.olehhilchenko.controller;

import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.model.factorymethod.DeveloperFactory;
import main.java.com.olehhilchenko.model.factorymethod.DeveloperFactoryImpl;
import main.java.com.olehhilchenko.repository.io.DeveloperRepository;
import main.java.com.olehhilchenko.repository.io.DeveloperRepositoryFacade;
import main.java.com.olehhilchenko.repository.io.singleton.AutoIncrementUniqueID;
import main.java.com.olehhilchenko.view.ActionTips;

public class DeveloperController {
    private DeveloperFactory developerFactory = new DeveloperFactoryImpl();
    private ActionTips actionTips = new ActionTips();
    private AccountController accountController = new AccountController();
    private SkillController skillController = new SkillController();
    private DeveloperRepository developerRepository = new DeveloperRepositoryFacade();

    public Developer createNewDeveloper (){
        Developer developer = developerFactory.createDeveloper();
        developer.setId(AutoIncrementUniqueID.getAutoIncrementUniqueID().getNextID());

        System.out.println(actionTips.ENTRY_DEVELOPER_NAME);
        developer.setName(ActionTips.scan());

        developer.setAccount(accountController.createNewAccount());
        developer.setSkills(skillController.createNewSkills());

        return developer;
    }
}
