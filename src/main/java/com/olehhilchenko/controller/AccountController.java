package main.java.com.olehhilchenko.controller;

import main.java.com.olehhilchenko.repository.io.JavaIOUtils;
import main.java.com.olehhilchenko.view.ActionTips;
import main.java.com.olehhilchenko.model.Account;
import main.java.com.olehhilchenko.model.AccountStatus;

public class AccountController {
    private ActionTips actionTips = new ActionTips();
    private final String ACCOUNT_STATUS_ACTIVE = "A";
    private final String ACCOUNT_STATUS_BANNED = "B";
    private final String ACCOUNT_STATUS_DELETED = "D";


    public Account createNewAccount() {
        Account account = new Account();

        actionTips.choiceAccountStatus();
        choiceAccountStatus(account);
        account.setId(JavaIOUtils.getNextID());
        return account;
    }

    private void choiceAccountStatus(Account a) {
        String choice = ActionTips.scan();
        if (ACCOUNT_STATUS_ACTIVE.equals(choice)) {
            a.setAccountStatus(AccountStatus.ACTIVE);
            return;
        } else if (ACCOUNT_STATUS_BANNED.equals(choice)) {
            a.setAccountStatus(AccountStatus.BANNED);
            return;
        } else if (ACCOUNT_STATUS_DELETED.equals(choice)) {
            a.setAccountStatus(AccountStatus.DELETED);
            return;
        } else {
            a.setAccountStatus(AccountStatus.DEFAULT);
            return;
        }
    }

    public Account updateAccount(Account updateAccount) {
        actionTips.choiceAccountStatus();
        choiceAccountStatus(updateAccount);

        return updateAccount;
    }
}
