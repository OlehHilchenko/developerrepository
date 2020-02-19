package main.java.com.olehhilchenko.view;


import main.java.com.olehhilchenko.model.Developer;
import main.java.com.olehhilchenko.repository.io.DeveloperRepository;
import main.java.com.olehhilchenko.repository.io.DeveloperService;
import main.java.com.olehhilchenko.controller.DeveloperController;

import java.util.Map;

public class Actions {
    private DeveloperRepository developerRepository = new DeveloperService();
    private DeveloperController developerController = new DeveloperController();
    private ActionTips actionTips = new ActionTips();
    private final String NEW_DEV = "1";
    private final String UPDATE_DEV = "2";
    private final String DELETE_DEV = "3";
    private final String VIEW_BY_ID_DEV = "4";
    private final String VIEW_ALL_DEV = "5";
    private final String EXIT_THE_APP = "6";


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
        Map<Long, Developer> developerMap = developerRepository.map();
        for (long key : developerMap.keySet()) {
            System.out.println(developerMap.get(key));
        }
    }

    public void mainMenu() {
        while (true) {
            actionTips.viewMainMenu();
            String scan = ActionTips.scan();
            if (NEW_DEV.equals(scan)) {//new
                createDeveloper();

            } else if (UPDATE_DEV.equals(scan)) {//update
                updateDeveloper();

            } else if (DELETE_DEV.equals(scan)) {//delete
                deleteById();

            } else if (VIEW_BY_ID_DEV.equals(scan)) {//view by id
                viewById();

            } else if (VIEW_ALL_DEV.equals(scan)) {//view all
                viewAll();

            } else if (EXIT_THE_APP.equals(scan)) {
                return;
            }
        }

    }
}
