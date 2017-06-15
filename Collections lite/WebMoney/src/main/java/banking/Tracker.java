package banking;

import clientData.Account;
import clientData.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Created by Saego on 13.06.2017.
 */
class Tracker {

    private Map<User, List<Account>> userListMap = new HashMap<User, List<Account>>();

    void addClient(User user){
        userListMap.put(user, new ArrayList<Account>());
    }

    public Map<User, List<Account>> getAllClients(){
        return this.userListMap;
    }

    public void addAccount(User user, Account account){
        this.userListMap.get(user).add(account);
    }

    public void removeClient(User user){
        this.userListMap.remove(user);
    }

    public void removeAccount(User user, Account account){
        this.userListMap.get(user).remove(account);
    }

    public List<Account> clientAccounts(User user){
        return this.userListMap.get(user);
    }

    public boolean transferMoney(User sourceUsr, Account sourceAcc, User destinationUsr, Account destinationAcc, int amountOfTransfer){
        boolean resultOfTransfer = false;
        if (this.userListMap.get(sourceUsr).contains(sourceAcc) && this.userListMap.get(destinationUsr).contains(destinationAcc)) {
            if (this.userListMap.get(sourceUsr).get(this.userListMap.get(sourceUsr).indexOf(sourceAcc)).getMoneyValue() >= amountOfTransfer){
                this.userListMap.get(sourceUsr).get(this.userListMap.get(sourceUsr).indexOf(sourceAcc)).setMoneyValue(
                        this.userListMap.get(sourceUsr).get(this.userListMap.get(sourceUsr).indexOf(sourceAcc)).getMoneyValue() - amountOfTransfer
                );
                this.userListMap.get(destinationUsr).get(this.userListMap.get(destinationUsr).indexOf(destinationAcc)).setMoneyValue(
                        this.userListMap.get(destinationUsr).get(this.userListMap.get(destinationUsr).indexOf(destinationAcc)).getMoneyValue() + amountOfTransfer
                );
                resultOfTransfer = true;
            }
        }
        return resultOfTransfer;
    }
}
