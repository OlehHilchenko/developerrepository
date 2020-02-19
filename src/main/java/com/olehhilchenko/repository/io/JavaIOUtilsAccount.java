package main.java.com.olehhilchenko.repository.io;

import main.java.com.olehhilchenko.repository.io.csvreaderandwriter.Csv;
import main.java.com.olehhilchenko.model.Account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaIOUtilsAccount extends JavaIOUtils<Account> {
    private final String ACCOUNTS_FILE_PATH = "src\\resources\\files\\accounts.csv";

    @Override
    public Map<Long, Account> dataFromFile() throws FileNotFoundException {
        Map<Long, Account> accountMap = new HashMap<Long, Account>();
        Csv.Reader reader = new Csv.Reader(new FileReader(ACCOUNTS_FILE_PATH));
        List<String> stringList;
        do {
            stringList = reader.readLine();
            if (stringList != null) {
                Account account = new Account();
                account.setId(stringList.get(0));
                account.setAccountStatus(stringList.get(1));
                accountMap.put(account.getId(), account);
            }
        } while (stringList != null);
        reader.close();
        return accountMap;
    }

    @Override
    public void dataToFile(Map<Long, Account> map) {
        Csv.Writer writer = new Csv.Writer(ACCOUNTS_FILE_PATH);
        for (Long key : map.keySet()) {
            Account account = map.get(key);
            writer.value("" + account.getId()).value("" + account.getAccountStatus()).newLine();
        }
        writer.close();
    }
}
