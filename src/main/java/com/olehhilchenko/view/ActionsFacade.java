package main.java.com.olehhilchenko.view;


import main.java.com.olehhilchenko.controller.DeveloperController;
import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.repository.io.DeveloperRepository;
import main.java.com.olehhilchenko.repository.io.DeveloperRepositoryFacade;

import java.util.List;

public class ActionsFacade {
    private DeveloperRepository developerRepository = new DeveloperRepositoryFacade();
    private DeveloperController developerController = new DeveloperController();
    private ActionTips actionTips = new ActionTips();


    private void createDeveloper() {
        developerRepository.insert(developerController.createNewDeveloper());
    }

    private void updateDeveloper() {
        System.out.println(actionTips.ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_CHANGE);
        Long id = Long.parseLong(ActionTips.scan());
        developerRepository.update(developerController.updateDeveloper(developerRepository.read(id)));
    }

    private void viewById() {
        System.out.println(actionTips.ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_SEE);
        Long id = Long.parseLong(ActionTips.scan());
        System.out.println(developerRepository.read(id));
    }

    private void deleteById() {
        System.out.println(actionTips.ENTRY_ID_REMOVABLE_DEVELOPER);
        Long id = Long.parseLong(ActionTips.scan());
        developerRepository.remove(id);
    }

    private void viewAll() {
        List<Developer> developerList = developerRepository.list();
        for (Developer developer : developerList) {
            System.out.println(developer);
        }
    }

    public void mainMenu() {
        while (true) {
            actionTips.viewMainMenu();
            String scan = ActionTips.scan();
            if ("1".equals(scan)) {//new
                createDeveloper();

            } else if ("2".equals(scan)) {//update
                updateDeveloper();

            } else if ("3".equals(scan)) {//delete
                deleteById();

            } else if ("4".equals(scan)) {//view by id
                viewById();

            } else if ("5".equals(scan)) {//view all
                viewAll();

            } else if ("6".equals(scan)) {
                return;
            }
        }

    }
}
