package main.java.com.olehhilchenko.model;

public class Account {
    private long id;
    private AccountStatus accountStatus;

    public Account(long id, AccountStatus accountStatus) {
        this.id = id;
        this.accountStatus = accountStatus;
    }

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        if (accountStatus.equals("DELETED"))
            this.accountStatus = AccountStatus.DELETED;
        else if (accountStatus.equals("BANNED"))
            this.accountStatus = AccountStatus.BANNED;
        else if (accountStatus.equals("ACTIVE"))
            this.accountStatus = AccountStatus.ACTIVE;
        else if (accountStatus.equals("DEFAULT"))
            this.accountStatus = AccountStatus.DEFAULT;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountStatus=" + accountStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        return accountStatus == account.accountStatus;
    }

    public boolean equalsByID(Object o){
        return this.id == ((Account) o).id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accountStatus != null ? accountStatus.hashCode() : 0);
        return result;
    }
}
