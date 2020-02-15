package main.java.com.olehhilchenko.controller;

import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.AccountStatus;
import main.java.com.olehhilchenko.model.factorymethod.AccountFactory;
import main.java.com.olehhilchenko.model.factorymethod.AccountFactoryImpl;
import main.java.com.olehhilchenko.repository.io.singleton.AutoIncrementUniqueID;
import main.java.com.olehhilchenko.view.ActionTips;

public class AccountController {
    private AccountFactory accountFactory = new AccountFactoryImpl();
    private ActionTips actionTips = new ActionTips();

    public Account createNewAccount() {
        Account account = accountFactory.createAccount();

        actionTips.choiceAccountStatus();
        choiceAccountStatus(account);
        account.setId(AutoIncrementUniqueID.getAutoIncrementUniqueID().getNextID());
        return account;
    }

    private void choiceAccountStatus(Account a) {
        while (true) {
            String choice = ActionTips.scan();
            if ("A".equals(choice)) {
                a.setAccountStatus(AccountStatus.ACTIVE);
                return;
            } else if ("B".equals(choice)) {
                a.setAccountStatus(AccountStatus.BANNED);
                return;
            } else if ("D".equals(choice)) {
                a.setAccountStatus(AccountStatus.DELETED);
                return;
            } else {
                a.setAccountStatus(AccountStatus.DEFAULT);
                return;
            }
        }
    }
}
