package Form;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private static Memory instance;

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    private Memory() {
        accounts = new ArrayList<>();
    }

    public static Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }
}
