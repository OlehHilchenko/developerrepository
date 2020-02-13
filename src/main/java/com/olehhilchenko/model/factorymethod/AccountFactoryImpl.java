package main.java.com.olehhilchenko.model.factorymethod;

import main.java.com.olehhilchenko.model.Account;

public class AccountFactoryImpl implements AccountFactory {

    @Override
    public Account createAccount() {
        return new Account();
    }
}
