package banking;

import clientData.Account;
import clientData.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Created by Saego on 13.06.2017.
 */
class Tracker {

    public Map<User, List<Account>> userListMap = new HashMap<User, List<Account>>();

    public void addClient(User user, List<Account> accounts){
        userListMap.put(user, accounts);
    }
}
